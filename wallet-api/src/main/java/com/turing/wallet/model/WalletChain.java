package com.turing.wallet.model;

public class WalletChain {
    private Long id;

    private String name;

    private Integer tagType;

    private String tagAddress;

    private String iconAddress;

    private String chainProtocol;

    private String chainBrowserAddress;

    private String chainBrowserTx;

    private Integer state;

    private String regEx;

    private String showName;

    private Integer defaultShow;

    private Boolean evmState;

    private Long createdAt;

    private Long updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTagType() {
        return tagType;
    }

    public void setTagType(Integer tagType) {
        this.tagType = tagType;
    }

    public String getTagAddress() {
        return tagAddress;
    }

    public void setTagAddress(String tagAddress) {
        this.tagAddress = tagAddress;
    }

    public String getIconAddress() {
        return iconAddress;
    }

    public void setIconAddress(String iconAddress) {
        this.iconAddress = iconAddress;
    }

    public String getChainProtocol() {
        return chainProtocol;
    }

    public void setChainProtocol(String chainProtocol) {
        this.chainProtocol = chainProtocol;
    }

    public String getChainBrowserAddress() {
        return chainBrowserAddress;
    }

    public void setChainBrowserAddress(String chainBrowserAddress) {
        this.chainBrowserAddress = chainBrowserAddress;
    }

    public String getChainBrowserTx() {
        return chainBrowserTx;
    }

    public void setChainBrowserTx(String chainBrowserTx) {
        this.chainBrowserTx = chainBrowserTx;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRegEx() {
        return regEx;
    }

    public void setRegEx(String regEx) {
        this.regEx = regEx;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Integer getDefaultShow() {
        return defaultShow;
    }

    public void setDefaultShow(Integer defaultShow) {
        this.defaultShow = defaultShow;
    }

    public Boolean getEvmState() {
        return evmState;
    }

    public void setEvmState(Boolean evmState) {
        this.evmState = evmState;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }
}