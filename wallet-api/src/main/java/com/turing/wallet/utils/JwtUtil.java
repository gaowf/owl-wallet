package com.turing.wallet.utils;


import com.coinbull.cacheclient.model.CacheUser;

import javax.servlet.http.HttpServletRequest;

import static com.turing.wallet.constants.Const.CACHE_USER;

public class JwtUtil {

    public static CacheUser getCacheUser(HttpServletRequest request){
        Object  obj = request.getAttribute(CACHE_USER);
        if(obj != null){
            return (CacheUser)obj;
        }
        return null;
    }
}

