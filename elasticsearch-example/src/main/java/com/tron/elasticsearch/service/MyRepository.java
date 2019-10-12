package com.tron.elasticsearch.service;


import com.tron.elasticsearch.entity.TestEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description
 * @auther tron
 * @create 2019-10-09
 */
@Service
public interface MyRepository extends ElasticsearchCrudRepository<TestEntity,String> {
    List<TestEntity> findTestEntitiesByContent(String content);

    List<TestEntity> findTestEntitiesByContentContains(String content);
}
