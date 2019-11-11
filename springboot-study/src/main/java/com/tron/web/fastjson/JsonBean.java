package com.tron.web.fastjson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @auther tron
 * @create 2019-11-10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class JsonBean {
    private String s;
    private Integer i;
    private Boolean b;
    private List l;
    private Map m;
}
