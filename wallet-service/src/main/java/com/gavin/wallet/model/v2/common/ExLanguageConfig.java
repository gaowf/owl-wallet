package com.turing.wallet.model.v2.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mac
 */
public class ExLanguageConfig implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 是否启用 1启用 0关闭
     */
    private Byte isOpen;

    /**
     * 语言key
     */
    private String key;

    /**
     * 语言
     */
    private String language;

    /**
     * 排序
     */
    private Byte sort;

    /**
     * 交易所ID
     */
    private Integer exchId;

    /**
     *
     */
    private Date ctime;

    /**
     *
     */
    private Date mtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Byte isOpen) {
        this.isOpen = isOpen;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Integer getExchId() {
        return exchId;
    }

    public void setExchId(Integer exchId) {
        this.exchId = exchId;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public static class Builder {
        private ExLanguageConfig obj;

        public Builder() {
            this.obj = new ExLanguageConfig();
        }

        public Builder id(Integer id) {
            obj.id = id;
            return this;
        }

        public Builder isOpen(Byte isOpen) {
            obj.isOpen = isOpen;
            return this;
        }

        public Builder key(String key) {
            obj.key = key;
            return this;
        }

        public Builder language(String language) {
            obj.language = language;
            return this;
        }

        public Builder sort(Byte sort) {
            obj.sort = sort;
            return this;
        }

        public Builder exchId(Integer exchId) {
            obj.exchId = exchId;
            return this;
        }

        public Builder ctime(Date ctime) {
            obj.ctime = ctime;
            return this;
        }

        public Builder mtime(Date mtime) {
            obj.mtime = mtime;
            return this;
        }

        public ExLanguageConfig build() {
            return this.obj;
        }
    }
}
