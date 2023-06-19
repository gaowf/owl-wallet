package com.turing.wallet.model.v2.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mac
 */
public class ConfigLanguage implements Serializable {
    /**
     *
     */
    private Integer id;

    /**
     * 配置key
     */
    private String configKey;

    /**
     * 语言key
     */
    private String langKey;

    /**
     *
     */
    private String content;

    /**
     * 描述
     */
    private String meta;

    /**
     *
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

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey == null ? null : configKey.trim();
    }

    public String getLangKey() {
        return langKey;
    }

    public void setLangKey(String langKey) {
        this.langKey = langKey == null ? null : langKey.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta == null ? null : meta.trim();
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
        private ConfigLanguage obj;

        public Builder() {
            this.obj = new ConfigLanguage();
        }

        public Builder id(Integer id) {
            obj.id = id;
            return this;
        }

        public Builder configKey(String configKey) {
            obj.configKey = configKey;
            return this;
        }

        public Builder langKey(String langKey) {
            obj.langKey = langKey;
            return this;
        }

        public Builder content(String content) {
            obj.content = content;
            return this;
        }

        public Builder meta(String meta) {
            obj.meta = meta;
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

        public ConfigLanguage build() {
            return this.obj;
        }
    }
}
