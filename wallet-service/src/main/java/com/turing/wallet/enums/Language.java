package com.turing.wallet.enums;

import com.turing.wallet.model.v2.common.ExLanguageConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 国际化语言包
 * ISO 639-1 语言规范
 * ISO 3166-1 国家规范
 * Created by zhongjingyun on 2017/11/3.
 */
public enum Language {
    Chinese("zh", 1, "zh_CN", "cnName", 1, 1, "简体中文", "4,1", "{familyName}{givenName}", "中文", "￥", "CNY", 2),
    English("en", 2, "en_US", "enName", 1, 1, "English", "5,2", "{givenName}{familyName}", "英文", "$", "USD", 2),
    Korean("ko", 3, "ko_KR", "koName", 1, 1, "한국어", "6,3", "{familyName}{givenName}", "韩文", "₩", "KRW", 0),
    Traditional_Chinese("el", 4, "el_GR", "cnName", 1, 1, "繁体中文", "8,7", "{familyName}{givenName}", "繁体中文", "￥", "CNY", 2),
    Mongolian("mn", 5, "mn_MN", "mnName", 1, 1, "Монгол хэл", "10,9", "{familyName}{givenName}", "蒙文", "₮", "MNT", 2),
    Russian("ru", 6, "ru_RU", "ruName", 1, 1, "русский язык", "12,11", "{familyName}{givenName}", "俄语", "₽", "RUB", 2),
    Japanese("ja", 7, "ja_JP", "jaName", 1, 1, "日本語", "14,13", "{familyName}{givenName}", "日语", "¥", "JPY", 2),
    Vietnamese("vi", 8, "vi_VN", "viName", 1, 1, "Tiếng Việt", "16,15", "{familyName}{givenName}", "越南语", "₫", "VND", 2),
    Indonesia("id", 9, "id_ID", "idName", 1, 1, "Indonesian", "18,17", "{familyName}{givenName}", "印尼语", "৲৳", "IDR", 2),

    ;

    // 语言编码
    public String lang;
    // 多语言id（这个字段给cms系统使用）
    public int langTypeId;
    // 多语言和国家编码
    public String langType;
    // 电话号码国家编码名字
    public String phoneCountryName;
    // 开启状态 1开启 0关闭
    public int status;
    // 后台语言的开启或者关闭 1开启 0关闭
    public int operateOpen;
    // 页面展示名字
    public String showName;
    // 后台cms系统分类id
    public String cmsTypeId;
    // 不同国家姓名顺序，familyName姓，givenName名
    public String nameOrder;
    // 描述
    public String description;
    // 货币符号
    public String moneySymbol;
    // 国家法定货币
    public String countryCoin;
    // 币种显示精度
    public int coinPrecision;

    Language(String lang, int langTypeId, String langType, String phoneCountryName, int status, int operateOpen, String showName, String cmsTypeId,
             String nameOrder, String description, String moneySymbol, String countryCoin, int coinPrecision) {
        this.lang = lang;
        this.langTypeId = langTypeId;
        this.langType = langType;
        this.phoneCountryName = phoneCountryName;
        this.status = status;
        this.operateOpen = operateOpen;
        this.showName = showName;
        this.cmsTypeId = cmsTypeId;
        this.nameOrder = nameOrder;
        this.description = description;
        this.moneySymbol = moneySymbol;
        this.countryCoin = countryCoin;
        this.coinPrecision = coinPrecision;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public int getLangTypeId() {
        return langTypeId;
    }

    public void setLangTypeId(int langTypeId) {
        this.langTypeId = langTypeId;
    }

    public String getLangType() {
        return langType;
    }

    public void setLangType(String langType) {
        this.langType = langType;
    }

    public String getPhoneCountryName() {
        return phoneCountryName;
    }

    public void setPhoneCountryName(String phoneCountryName) {
        this.phoneCountryName = phoneCountryName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public int getOperateOpen() {
        return operateOpen;
    }

    public void setOperateOpen(int operateOpen) {
        this.operateOpen = operateOpen;
    }

    public String getCmsTypeId() {
        return cmsTypeId;
    }

    public void setCmsTypeId(String cmsTypeId) {
        this.cmsTypeId = cmsTypeId;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoneySymbol() {
        return moneySymbol;
    }

    public void setMoneySymbol(String moneySymbol) {
        this.moneySymbol = moneySymbol;
    }

    public String getCountryCoin() {
        return countryCoin;
    }

    public void setCountryCoin(String countryCoin) {
        this.countryCoin = countryCoin;
    }

    public int getCoinPrecision() {
        return coinPrecision;
    }

    public void setCoinPrecision(int coinPrecision) {
        this.coinPrecision = coinPrecision;
    }

    public static Language fromValue(String lang) {
        for (Language t : Language.values()) {
            if (t.lang.equalsIgnoreCase(lang)) {
                return t;
            }
        }
        //适配匹配不到报错，默认中文
        return Chinese;
    }

    public static Language getLanguage(String lang) {
        for (Language t : Language.values()) {
            if (t.langType.equalsIgnoreCase(lang)) {
                return t;
            }
        }
        //适配匹配不到报错，默认中文
        return Chinese;
    }

    public static Language fromValueByActivity(String lang) {
        List<Language> languageList = new ArrayList<Language>();
        languageList.add(Chinese);
        languageList.add(English);
        languageList.add(Traditional_Chinese);
        languageList.add(Vietnamese);

        for (Language t : languageList) {
            if (t.lang.equalsIgnoreCase(lang)) {
                return t;
            }
        }
        //适配匹配不到报错，默认中文
        return English;
    }

    /**
     * 根据国家法币获取语言
     *
     * @return:
     * @Date: 2020-06-03
     */
    public static Language fromCountryCoin(String countryCoin) {
        for (Language t : Language.values()) {
            if (t.countryCoin.equalsIgnoreCase(countryCoin)) {
                return t;
            }
        }
        return English;
    }

    public static Language fromLangType(String langType) {
        for (Language t : Language.values()) {
            if (t.langType.equalsIgnoreCase(langType)) {
                return t;
            }
        }
        return Language.English;
    }

    //获取已开通的语言
    public static List<Language> getStartLanguage() {
        ArrayList<Language> langList = new ArrayList<Language>();
        for (Language t : Language.values()) {
            if (t.status == 1) {
                langList.add(t);
            }
        }
        return langList;
    }

    /**
     * 获取后台已开通的语言
     *
     * @return:
     * @Date: 2020-06-03
     */
    public static List<Language> getOperateStartLanguage() {
        ArrayList<Language> langList = new ArrayList<Language>();
        Arrays.asList(Language.values()).forEach(
                language -> {
                    if (language.operateOpen == 1) {
                        langList.add(language);
                    }
                }
        );


        return langList;
    }

    public static Language fromName(String name) {
        for (Language t : Language.values()) {
            if (t.name().equals(name)) {
                return t;
            }
        }
        return null;
    }

    public static List<Language> getOpenLanguageListByKvStore(List<ExLanguageConfig> configList) {
        ArrayList<Language> langList = new ArrayList<>();
        List<Language> languageEnum = Arrays.asList(Language.values());
        List<String> sequenceLangList = new ArrayList<>();
        for (ExLanguageConfig config : configList) {
            sequenceLangList.add(config.getKey());
        }
        if (sequenceLangList.isEmpty()) {
            for (Language language : languageEnum) {
                if (language.getStatus() != 0) {
                    langList.add(language);
                }
            }
        } else {
            for (String langString : sequenceLangList) {
                for (Language language : languageEnum) {
                    if (language.getLangType().equals(langString)) {
                        langList.add(language);
                    }
                }
            }
        }
        return langList;
    }
}