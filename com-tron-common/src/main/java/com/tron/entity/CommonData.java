package com.tron.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Description
 * @auther tron
 * @create 2019-11-05
 */

@Data
@Accessors(chain = true)
public class CommonData {
    private String string;
    private Integer integer;
}
