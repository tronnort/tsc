package com.tron.web.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;

public class QueryWrapperFactory {
    public static  <T>  QueryWrapper  create (T t, Map<String,String> map) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        map.forEach((k,v)->{
            if (v.startsWith("=")) {
                queryWrapper.eq(k, v.replace("=",""));
            }
            if (v.startsWith("!=")) {
                queryWrapper.ne(k, v.replace("!=", ""));
            }
            if (v.startsWith(">")) {
                queryWrapper.gt(k, v.replace(">",""));
            }
            if (v.startsWith("<")) {
                queryWrapper.lt(k, v.replace("<",""));
            }
            if (v.startsWith("%") && v.endsWith("%")) {
                queryWrapper.like(k, v.replaceAll("%",""));
            }
            if (v.equals("=null")) {
                queryWrapper.isNull(k);
            }
            if (v.equals("!=null")) {
                queryWrapper.isNotNull(k);
            }
            if (v.startsWith("-")) {
                queryWrapper.orderByDesc(k);
            }
            if (v.endsWith("+")) {
                queryWrapper.orderByAsc(k);
            }
        });
        return queryWrapper;
    }
}
