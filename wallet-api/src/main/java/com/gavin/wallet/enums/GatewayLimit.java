package com.turing.wallet.enums;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Refill;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;

/**
 * 网关限制.
 */
public enum GatewayLimit {
    SMS {
        public Bandwidth getLimit() {
            return Bandwidth.classic(5, Refill.intervally(2, Duration.ofMinutes(1)));
        }
    },

    EMAIL {
        public Bandwidth getLimit() {
            return Bandwidth.classic(10, Refill.intervally(2, Duration.ofMinutes(1)));
        }
    },

    IP {
        public Bandwidth getLimit() {
            return Bandwidth.classic(5, Refill.intervally(2, Duration.ofMinutes(1)));
        }
    };

    public abstract Bandwidth getLimit();

    public static GatewayLimit resolveLimitFromUserId(Long uid, String api) {
        if (uid == null || StringUtils.isBlank(api)) {
            return IP;
        }
        if (api.equalsIgnoreCase("sms")) {
            return SMS;
        }
        if (api.equalsIgnoreCase("email")) {
            return EMAIL;
        }

        return IP;


    }
}
