package com.turing.wallet.utils;

import com.turing.wallet.constants.Const;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 *
 */
@Slf4j
public final class NetUtil {

    /**
     * 获取客户端类型.
     *
     * @return
     */
    public static String getClientType() {
        HttpServletRequest request =
                ((ServletRequestAttributes)
                        Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                        .getRequest();

        String os = request.getHeader(Const.EXCH_CLIENT_TYPE);
        if (StringUtils.isNotBlank(os)) {
            return os;
        }

        String browserDetails = request.getHeader("User-Agent");
        String userAgent = browserDetails;

        log.debug("User Agent for the request is===>" + browserDetails);

        if (userAgent.toLowerCase().contains("windows")) {
            os = "Windows";
        } else if (userAgent.toLowerCase().contains("mac")) {
            os = "Mac";
        } else if (userAgent.toLowerCase().contains("x11")) {
            os = "Unix";
        } else if (userAgent.toLowerCase().contains("android")) {
            os = "Android";
        } else if (userAgent.toLowerCase().contains("iphone")) {
            os = "IPhone";
        } else {
            //      os = "UnKnown";
            os = request.getHeader("Platform-CU");
            if (StringUtils.isBlank(os)) {
                os = "UnKnown";
            }
        }

        log.debug("Operating System======>" + os);

        return os;
    }

    /**
     * 获取ip地址.
     *
     * @return
     */
    public static String getIp() {
        HttpServletRequest request =
                ((ServletRequestAttributes)
                        Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                        .getRequest();
        String ip = request.getHeader("X-Real-IP");
        log.debug("X-Real-IP -> {}", ip);
        if(ip != null && ip.length() != 0 && !"unknown".equalsIgnoreCase(ip)){
            String[] arr = StringUtils.split(ip, ",");
            return arr[arr.length - 1];
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        log.debug("RemoteAddr -> {}",ip);
        return ip;

//        String ip = request.getHeader("U-Real-IP");
//        log.debug("U-Real-IP -> {}", ip);
//        if (ip != null && !isValidAddress(ip)) {
//            ip = null;
//        }
//
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("x-forwarded-for");
//            log.debug("x-forwarded-for -> {}", ip);
//            if (ip != null && !isValidAddress(ip)) {
//                ip = null;
//            }
//        }
//
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//            log.debug("Proxy-Client-IP -> {}", ip);
//            if (ip != null && !isValidAddress(ip)) {
//                ip = null;
//            }
//        }
//
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//            log.debug("WL-Proxy-Client-IP -> {}", ip);
//            if (ip != null && !isValidAddress(ip)) {
//                ip = null;
//            }
//        }
//
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//            log.debug("remoteAddr -> {}", ip);
//            if (ip != null && !isValidAddress(ip)) {
//                ip = null;
//            }
//        }
//
//        return ip;
    }

    /**
     * 获取语言.
     *
     * @return
     */
    public static String getLanguage() {
        HttpServletRequest request =
                ((ServletRequestAttributes)
                        Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                        .getRequest();
        String language = request.getHeader(Const.EXCH_LANGUAGE);
        if (StringUtils.isNotBlank(language)) {
            return language;
        }

        return "zh_CN";
    }

    /**
     *
     * 获取版本号
     */
    public static String getAppVersion() {
        HttpServletRequest request =
                ((ServletRequestAttributes)
                        Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                        .getRequest();
        String appVersion = request.getHeader(Const.APP_VERSION);
        if (StringUtils.isNotBlank(appVersion)) {
            return appVersion;
        }

        return "";
    }

    public static String getDeviceId() {
        HttpServletRequest request =
                ((ServletRequestAttributes)
                        Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                        .getRequest();
        String deviceId = request.getHeader(Const.EXCH_DEVICE_ID);
        if (StringUtils.isNotBlank(deviceId)) {
            return deviceId;
        }

        return "";
    }

    /**
     * 获取exchId
     *
     * @return
     */
    public static String getExchId() {
        HttpServletRequest request =
                ((ServletRequestAttributes)
                        Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                        .getRequest();
        String exchId = request.getHeader(Const.EXCH_ID);
        if (StringUtils.isNotBlank(exchId)) {
            return exchId;
        }
        return "0";
    }

    private static boolean isValidAddress(String ip) {
        if (ip == null) {
            return false;
        }

        for (int i = 0; i < ip.length(); ++i) {
            char ch = ip.charAt(i);
            if (ch >= '0' && ch <= '9') {
                // continue;
            } else if (ch >= 'A' && ch <= 'F') {
                // continue;
            } else if (ch >= 'a' && ch <= 'f') {
                // continue;
            } else if (ch == '.' || ch == ':') {
                // continue;
            } else {
                return false;
            }
        }

        return true;
    }
    /**
     * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
     * @param version1
     * @param version2
     */
    public static int compareVersion(String version1, String version2){
        String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用.；
        String[] versionArray2 = version2.split("\\.");
        int idx = 0;
        int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
        int diff = 0;
        while (idx < minLength
                && (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
                && (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
            ++idx;
        }
        //如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
        diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
        return diff;
    }
}
