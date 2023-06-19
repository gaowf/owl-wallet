package com.turing.wallet.config;

import com.turing.wallet.utils.ConfigSignUtil;
import com.ulisesbocchio.jasyptspringboot.EncryptablePropertyResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanCreationNotAllowedException;

import java.time.LocalDateTime;

/**
 * 从其他系统复制来的兼容代码，做数据库密码加解密
 */
@Slf4j
public class MyEncryptablePropertyResolver implements EncryptablePropertyResolver {

    private String serverName = "wbfooapi";

    private final SignConfig signConfig;

    public MyEncryptablePropertyResolver(SignConfig signConfig) {
        this.signConfig = signConfig;
    }

    @Override
    public String resolvePropertyValue(String s) {
        if (null != s && s.startsWith(MyEncryptablePropertyDetector.ENCODED_PASSWORD_HINT)) {
            // 对配置文件加密值进行解密。加密方式可以自定义
            if (null != s && s.startsWith(MyEncryptablePropertyDetector.ENCODED_PASSWORD_HINT)) {
                s = s.substring(MyEncryptablePropertyDetector.ENCODED_PASSWORD_HINT.length());

                String dateTime = LocalDateTime.now().toString();

                log.info("encrypt-decrypt-once-s:{}", s);
                String sendDec = ConfigSignUtil.sendDec(s, serverName, dateTime, signConfig);
                if (sendDec != null) {
                    return sendDec;
                } else {
                    sendDec = ConfigSignUtil.sendDec(s, serverName, dateTime, signConfig);
                    if (sendDec != null) {
                        return sendDec;
                    } else {
                        log.error("encrypt-decrypt-once-again BeansException -s:{},sendDec:{}", s, sendDec);
                        throw new BeanCreationNotAllowedException(
                                "EncrypPropertyPlaceholderConfigurer", "sendDec is two null");
                    }
                }
            }
        }
        return s;
    }
}
