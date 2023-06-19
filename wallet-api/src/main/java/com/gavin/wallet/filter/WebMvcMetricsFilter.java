/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.turing.wallet.filter;

import com.timgroup.statsd.StatsDClient;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Tag;
import org.springframework.boot.actuate.metrics.web.servlet.WebMvcTags;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.*;
import org.springframework.web.util.NestedServletException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.util.*;

/**
 * copy from {@link org.springframework.boot.actuate.metrics.web.servlet.WebMvcMetricsFilter}
 */
public class WebMvcMetricsFilter extends OncePerRequestFilter {

  private final StatsDClient statsDClient;

  private final String  metricName = "http.server.requests";
  private final boolean autoTimeRequests;

  public WebMvcMetricsFilter(StatsDClient statsDClient, boolean autoTimeRequests) {
    this.statsDClient = statsDClient;
    this.autoTimeRequests = autoTimeRequests;
  }

  @Override
  protected boolean shouldNotFilterAsyncDispatch() {
    return false;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain)
      throws ServletException, IOException {
    filterAndRecordMetrics(request, response, filterChain);
  }

  private void filterAndRecordMetrics(HttpServletRequest request, HttpServletResponse response,
                                      FilterChain filterChain) throws IOException, ServletException {
    long start = System.currentTimeMillis();
    try {
      filterChain.doFilter(request, response);
      if (!request.isAsyncStarted()) {
        // Only record when async processing has finished or never been started.
        // If async was started by something further down the chain we wait
        // until the second filter invocation (but we'll be using the
        // TimingContext that was attached to the first)
        Throwable exception = (Throwable) request
            .getAttribute(DispatcherServlet.EXCEPTION_ATTRIBUTE);
        record(start, response, request, exception);
      }
    } catch (NestedServletException ex) {
      response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      record(start, response, request, ex.getCause());
      throw ex;
    } catch (ServletException | IOException | RuntimeException ex) {
      record(start, response, request, ex);
      throw ex;
    }
  }

  private void record(long start, HttpServletResponse response, HttpServletRequest request,
                      Throwable exception) {
    Object handlerObject = request.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);
    Set<Timed> annotations = getTimedAnnotations(handlerObject);
    if (annotations.isEmpty()) {
      if (this.autoTimeRequests) {
        if(statsDClient != null) {
          statsDClient.time(this.metricName, System.currentTimeMillis() - start,
                  tags(response, request, exception));
        }
      }
    } else {
      for (Timed annotation : annotations) {
        if(statsDClient != null) {
          statsDClient.time(annotation.value().isEmpty() ? this.metricName : annotation.value(),
                  System.currentTimeMillis() - start,
                  tags(response, request, exception));
        }
      }
    }
  }

  private Set<Timed> getTimedAnnotations(Object handler) {
    if (!(handler instanceof HandlerMethod)) {
      return Collections.emptySet();
    }
    return getTimedAnnotations((HandlerMethod) handler);
  }

  private Set<Timed> getTimedAnnotations(HandlerMethod handler) {
    Set<Timed> timed = findTimedAnnotations(handler.getMethod());
    if (timed.isEmpty()) {
      return findTimedAnnotations(handler.getBeanType());
    }
    return timed;
  }

  private Set<Timed> findTimedAnnotations(AnnotatedElement element) {
    return AnnotationUtils.getDeclaredRepeatableAnnotations(element, Timed.class);
  }

  private String[] tags(HttpServletResponse response, HttpServletRequest request,
                        Throwable exception) {
    String[] tags = new String[4];
    tags[0] = tagToString(WebMvcTags.method(request));
    tags[1] = tagToString(WebMvcTags.uri(request, response, true));
    tags[2] = tagToString(WebMvcTags.exception(exception));
    tags[3] = tagToString(WebMvcTags.status(response));
    return tags;
  }

  private String tagToString(Tag tag) {
    return tag.getKey() + ":" + tag.getValue();
  }
}
