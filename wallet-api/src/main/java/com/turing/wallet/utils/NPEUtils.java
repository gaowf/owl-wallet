package com.turing.wallet.utils;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.util.CollectionUtils;

/**
 * 空值处理.
 */
@Slf4j
public final class NPEUtils {
    private NPEUtils() {
        //
    }

    /**
     * 空值预处理.
     *
     * @param obj
     */
    public static void pre(Object obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (final Field field : fields) {
                field.setAccessible(true);

                if (field.get(obj) != null) {
                    continue;
                }
                String filedTypeName = field.getType().getName();
                if ("java.lang.Long".equals(filedTypeName)) {
                    field.set(obj, 0L);
                } else if ("java.lang.String".equals(filedTypeName)) {
                    field.set(obj, "");
                } else if ("java.util.Date".equals(filedTypeName)) {
                    field.set(obj, new Date());
                } else if ("java.lang.Double".equals(filedTypeName)) {
                    field.set(obj, 0.0d);
                } else if ("java.lang.Integer".equals(filedTypeName)) {
                    field.set(obj, 0);
                } else if ("java.lang.Float".equals(filedTypeName)) {
                    field.set(obj, 0.0f);
                } else if ("java.sql.Timestamp".equals(filedTypeName)) {
                    field.set(obj, Timestamp.from(Instant.now()));
                } else if ("java.math.BigDecimal".equals(filedTypeName)) {
                    field.set(obj, BigDecimal.ZERO);
                }
            }
        } catch (IllegalAccessException e) {
            log.error("e ->{}", ExceptionUtils.getStackTrace(e));
        }
    }


    public static void preList(List objList) {
        if (CollectionUtils.isEmpty(objList)) {
            return;
        }
        for (Object obj : objList) {
            pre(obj);
        }
    }

}
