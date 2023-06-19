package com.turing.wallet.service.blackbox;

import java.math.BigDecimal;

/**
 * 黑盒服务.
 */
public interface BlackBoxService {

    /**
     * 提币黑盒指纹.
     *
     * @param id          记录id.
     * @param symbol      币种:ETH
     * @param addressTo   充币地址.
     * @param amount      金额
     * @param fee         手续费.
     * @param uid         用户id.
     * @param time        提币时间.
     * @param fingerprint 提币指纹
     * @return 是否调用成功.
     */
    boolean withdrawFingerprint(
            Long id,
            String symbol,
            String addressTo,
            BigDecimal amount,
            BigDecimal fee,
            Long uid,
            Long time,
            String fingerprint);

    /**
     * 获取签名uuid.
     *
     * @param exchDeviceId 设备id.
     * @param exchId       交易所id.
     * @param ip           ip.
     * @param deviceType   设备类型.
     * @return 设备uuid.
     */
    String uuid(String exchDeviceId, String exchId, String ip, String deviceType);

    /**
     * 密码加密.
     *
     * @param password 原始密码.
     * @param id       用户id.
     * @param exchId   交易所id.
     * @return 密码key.
     */
    String passwordEncrypt(String password, long id, String exchId);

    /**
     * 密码校验.
     *
     * @param password 密码.
     * @param expected 期望结果.
     * @param id       用户id.
     * @param exchId   交易所id.
     * @return 校验结果key.
     */
    String passwordVerification(String password, String expected, long id, String exchId);

    /**
     * 更新设备最后使用用户.
     *
     * @param deviceId 设备id.
     * @param userId   user id.
     * @param exId     交易所id.
     * @return
     */
    String updateLastDeviceUser(String deviceId, long userId, int exId);

    /**
     * 重加载UUID.
     *
     * @param exId       交易所id.
     * @param exDeviceId 设备id.
     * @return 设备uuid.
     */
    String reloadUUID(String exId, String exDeviceId);

    /**
     * 生成指纹
     *
     * @return:
     * @Date: 2020-08-25
     */
    String genInfoFingerprint(Long uid, String mobile, String email, String googleSecret);

    /**
     * 校验指纹
     *
     * @return:
     * @Date: 2020-08-25
     */
    Boolean checkInfoFingerprint(Long uid, String mobile, String email, String googleSecret, String fingerprint);

}
