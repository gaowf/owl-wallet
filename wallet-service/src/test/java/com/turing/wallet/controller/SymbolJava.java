package com.turing.wallet.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * 分区json生成
 */
public class SymbolJava {

    public static void main(String args[]) {

        ArrayList arrayList = new ArrayList();

        add1(arrayList);
        add2(arrayList);
        add3(arrayList);

        System.out.println("{regions:" + JSONObject.toJSONString(arrayList) + "}");

    }

    private static void add1(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("1");
        tag.setEn_US("Main");
        tag.setZh_CN("主区");
        tag.setJa_JP("メインエリア");
        tag.setKo_KR("메인존");
        arrayList.add(tag);
    }
    private static void add2(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("2");
        tag.setEn_US("New");
        tag.setZh_CN("创新");
        tag.setJa_JP("イノベーションエリア");
        tag.setKo_KR("이노베이션존");
        arrayList.add(tag);
    }
    private static void add3(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("3");
        tag.setEn_US("Open");
        tag.setZh_CN("开放区");
        tag.setJa_JP("オープンエリア");
        tag.setKo_KR("오픈존");
        arrayList.add(tag);
    }


    @Getter
    @Setter
    public static class Tags {
        private String key;

        private String zh_CN;
        private String en_US;

        private String ko_KR;
        private String ja_JP;
    }
}
