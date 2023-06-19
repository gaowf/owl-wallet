package com.turing.wallet.bean.request;

import com.turing.wallet.bean.base.BaseRequestData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("语言")
public class LanguageData extends BaseRequestData {

    private static final long serialVersionUID = -2686246761777993978L;

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data {

        @ApiModelProperty("语言")
        private String language;

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }
    }
}
