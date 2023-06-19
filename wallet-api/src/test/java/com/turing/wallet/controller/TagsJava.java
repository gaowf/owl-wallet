package com.turing.wallet.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * 板块json配置生成
 */
public class TagsJava {

    public static void main(String args[]) {

        ArrayList arrayList = new ArrayList();

        add1(arrayList);
        add2(arrayList);
        add3(arrayList);
        add4(arrayList);
        add5(arrayList);
        add6(arrayList);
        add7(arrayList);

        System.out.println("{tags:" + JSONObject.toJSONString(arrayList) + "}");

    }

    private static void add1(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("defi");
        tag.setEnName("Defi");
        tag.setChName("Defi");
        tag.setEn_US("Defi");
        tag.setZh_CN("Defi");
        tag.setJa_JP("Defi");
        tag.setKo_KR("Defi");
        arrayList.add(tag);
    }
    private static void add2(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("pow");
        tag.setEnName("POW");
        tag.setChName("POW");
        tag.setEn_US("POW");
        tag.setZh_CN("POW");
        tag.setJa_JP("POW");
        tag.setKo_KR("POW");
        arrayList.add(tag);
    }
    private static void add3(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("pos");
        tag.setEnName("POS");
        tag.setChName("POS");
        tag.setEn_US("POS");
        tag.setZh_CN("POS");
        tag.setJa_JP("POS");
        tag.setKo_KR("POS");
        arrayList.add(tag);
    }
    private static void add4(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("nft");
        tag.setEnName("NFT");
        tag.setChName("NFT");
        tag.setEn_US("NFT");
        tag.setZh_CN("NFT");
        tag.setJa_JP("NFT");
        tag.setKo_KR("NFT");
        arrayList.add(tag);
    }

    private static void add5(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("bsc");
        tag.setEnName("BSC");
        tag.setChName("BSC");
        tag.setEn_US("BSC");
        tag.setZh_CN("BSC");
        tag.setJa_JP("BSC");
        tag.setKo_KR("BSC");
        arrayList.add(tag);
    }


    private static void add6(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("dot");
        tag.setEnName("dot");
        tag.setChName("波卡生态");
        tag.setEn_US("dot");
        tag.setZh_CN("波卡生态");
        tag.setJa_JP("Polkadotエコシステム");
        tag.setKo_KR("폴카닷 에코시스템");
        arrayList.add(tag);
    }

    private static void add7(ArrayList arrayList) {

        Tags tag = new Tags();
        tag.setKey("P2E");
        tag.setEnName("P2E");
        tag.setChName("区块链游戏");
        tag.setEn_US("P2E");
        tag.setZh_CN("区块链游戏");
        tag.setJa_JP("ブロックチェーンゲーム");
        tag.setKo_KR("블록체인 게임");
        arrayList.add(tag);
    }


    @Getter
    @Setter
    public static class Tags {
        private String key;
        private String enName;
        private String chName;
        private String zh_CN;
        private String en_US;
        private String ko_KR;
        private String ja_JP;
    }
}
