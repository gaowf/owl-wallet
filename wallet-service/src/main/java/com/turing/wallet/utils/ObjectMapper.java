package com.turing.wallet.utils;


import com.fasterxml.jackson.core.JsonProcessingException;

public class ObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public String writeValueAsString(Object value) {
        // TODO Auto-generated method stub
        try {
            return super.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw ExceptionUtil.unchecked(e);
        }
    }


    @Override
    public <T> T readValue(String content, Class<T> valueType) {

        try {
            return super.readValue(content, valueType);
        } catch (Exception e) {
            throw ExceptionUtil.unchecked(e);
        }
    }
}
