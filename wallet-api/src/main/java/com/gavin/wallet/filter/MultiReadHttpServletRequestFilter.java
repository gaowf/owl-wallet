package com.turing.wallet.filter;

import com.turing.wallet.wrapper.MultiReadHttpServletRequestWrapper;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

/**
 * 多次读取 request body filter.
 */
@Component
public class MultiReadHttpServletRequestFilter implements Filter {
    @Override
    public void doFilter(
            ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        /* wrap the request in order to read the input stream multiple times */
        MultiReadHttpServletRequestWrapper multiReadRequest =
                new MultiReadHttpServletRequestWrapper((HttpServletRequest) servletRequest);

        /* here I read the input stream and do my thing with it; when I pass the
         * wrapped request through the filter chain, the rest of the filters, and
         * request handlers may read the cached input stream
         */
        // multiReadRequest.getInputStream();
        // multiReadRequest.getReader();

        filterChain.doFilter(multiReadRequest, servletResponse);
    }
}
