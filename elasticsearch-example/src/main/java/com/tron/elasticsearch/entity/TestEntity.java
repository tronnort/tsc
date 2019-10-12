package com.tron.elasticsearch.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @Description
 * @auther tron
 * @create 2019-10-12
 */
@Document(indexName = "elasticData")
@Data
public class TestEntity {
    @Id
    private String id;
    private String content;
}
