package com.turing.wallet.model;

public class WalletCurrency {
    private Long id;

    private String currencyCode;

    private String iconAddress;

    private Long chainId;

    private String chainName;

    private String chainShowName;

    private String chainProtocol;

    private String walletCurrencyName;

    private String contractAddress;

    private Integer tagType;

    private String tagAddress;

    private String addressRegular;

    private Byte defaultChain;

    private Integer currencyType;

    private Integer sort;

    private Integer state;

    private Long createdAt;

    private Long updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getIconAddress() {
        return iconAddress;
    }

    public void setIconAddress(String iconAddress) {
        this.iconAddress = iconAddress;
    }

    public Long getChainId() {
        return chainId;
    }

    public void setChainId(Long chainId) {
        this.chainId = chainId;
    }

    public String getChainName() {
        return chainName;
    }

    public void setChainName(String chainName) {
        this.chainName = chainName;
    }

    public String getChainShowName() {
        return chainShowName;
    }

    public void setChainShowName(String chainShowName) {
        this.chainShowName = chainShowName;
    }

    public String getChainProtocol() {
        return chainProtocol;
    }

    public void setChainProtocol(String chainProtocol) {
        this.chainProtocol = chainProtocol;
    }

    public String getWalletCurrencyName() {
        return walletCurrencyName;
    }

    public void setWalletCurrencyName(String walletCurrencyName) {
        this.walletCurrencyName = walletCurrencyName;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
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

    public String getAddressRegular() {
        return addressRegular;
    }

    public void setAddressRegular(String addressRegular) {
        this.addressRegular = addressRegular;
    }

    public Byte getDefaultChain() {
        return defaultChain;
    }

    public void setDefaultChain(Byte defaultChain) {
        this.defaultChain = defaultChain;
    }

    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
        this.currencyType = currencyType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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