package com.turing.wallet.dto.config;

import com.turing.wallet.enums.BoolStatus;

import java.util.List;

/**
 * 签名配置.
 */
public class SignConfig {
    private byte enable;
    private byte signTest;
    private List<String> exclusions;

    public byte getEnable() {
        return enable;
    }

    public void setEnable(byte enable) {
        this.enable = enable;
    }

    public byte getSignTest() {
        return signTest;
    }

    public void setSignTest(byte signTest) {
        this.signTest = signTest;
    }

    public List<String> getExclusions() {
        return exclusions;
    }

    public void setExclusions(List<String> exclusions) {
        this.exclusions = exclusions;
    }

    public boolean isEnable() {
        return enable == BoolStatus.ENABLE.getValue();
    }

    public boolean isEnableSignTest() {
        return signTest == BoolStatus.ENABLE.getValue();
    }
}
