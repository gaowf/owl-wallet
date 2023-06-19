package com.turing.wallet.enums;


public enum SymbolWhiteListStatus {
    OPEN(1, "开启"),
    CLOSE(2, "关闭"),
    ;

    public Integer status;
    public String description;

    SymbolWhiteListStatus(Integer status, String description) {
        this.status = status;
        this.description = description;
    }

    public Integer getValue() {
        return status;
    }

    public void setValue(Integer value) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
