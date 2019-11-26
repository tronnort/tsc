package com.tron.web.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import java.util.Map;

public class QueryWrapperFactory {
    public static <T> QueryWrapper create(T t, Map<String, String> map) {
        if (map.isEmpty()) {
            return null;
        }
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        map.forEach((k, v) -> {
            if (v.trim().startsWith("=")) {
                queryWrapper.eq(false, k, v.replace("=", ""));
            }else
            if (v.trim().startsWith("!=")) {
                queryWrapper.ne(false, k, v.replace("!=", ""));
            }else
            if (v.trim().startsWith(">")) {
                queryWrapper.gt(false, k, v.replace(">", ""));
            }else
            if (v.trim().startsWith("<")) {
                queryWrapper.lt(false, k, v.replace("<", ""));
            }else
            if (v.trim().startsWith("%") && v.endsWith("%")) {
                queryWrapper.like(false, k, v.replaceAll("%", ""));
            }else
            if (v.trim().equals("=null")) {
                queryWrapper.isNull(k);
            }else
            if (v.trim().equals("!=null")) {
                queryWrapper.isNotNull(k);
            }else
            if (v.trim().startsWith("-")) {
                queryWrapper.orderByDesc(k);
            }else
            if (v.trim().endsWith("+")) {
                queryWrapper.orderByAsc(k);
            }

        });
        return queryWrapper;
    }

}
