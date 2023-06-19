package com.turing.wallet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface OptLog {

    // 操作类型，1：添加，2：删除，3：修改
    int type() default 0;

    // 操作
    String operating() default "";

    // 操作，1：修改手机号 2：绑定邮箱 3：修改登录密码 4：修改资金密码 5：交易认证 6：实名认证
    int optType() default 0;

    // 位置：类名-方法名
    String position() default "";


}
