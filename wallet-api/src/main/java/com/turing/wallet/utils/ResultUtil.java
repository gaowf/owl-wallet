package com.turing.wallet.utils;

import com.alibaba.fastjson.JSONObject;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;


/**
 * 接口返回工具类
 *
 * @author zhongjingyun
 */
public class ResultUtil {


    /**
     * 根据传入的属性名称，获取对象中的属性封装到map中
     *
     * @param propertys 可变参数，传递需要取出的属性名称
     * @return
     */
    public static Map<String, Object> objToMap(Object obj, String... propertys) throws Exception {
        if (obj == null) return null;

        //参数数组转list，便于取出同名的属性
        List<String> proList = Arrays.asList(propertys);

        //获取指定的属性封装
        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0 || !proList.contains(key)) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter != null ? getter.invoke(obj) : null;
            map.put(key, value);
        }

        return map;
    }

    /**
     * 根据传入的属性名称，获取对象中的属性封装到map中
     *
     * @param propertys 可变参数，传递需要取出的属性名称
     * @return
     */
    public static List<Map<String, Object>> ListToMapList(List objList, String... propertys) throws Exception {
        if (objList == null) return null;
        ArrayList<Map<String, Object>> mapLisp = new ArrayList<>();
        for (Object obj : objList) {
            mapLisp.add(objToMap(obj, propertys));
        }
        return mapLisp;
    }

    /**
     * 根据传入的属性名称，获取对象中的属性封装到map中
     *
     * @param propertys 可变参数，传递需要取出的属性名称
     * @return
     */
    public static String objToJson(Object obj, String... propertys) throws Exception {
        if (obj == null) return null;

        //参数数组转list，便于取出同名的属性
        List<String> proList = Arrays.asList(propertys);

        //获取指定的属性封装
        Map<String, Object> map = new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0 || !proList.contains(key)) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter != null ? getter.invoke(obj) : null;
            map.put(key, value);
        }

        return JSONObject.toJSONString(map);
    }
}
