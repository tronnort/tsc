package com.tron.web.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tron.web.mybatis.entity.TestData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface TestMapper extends BaseMapper<TestData> {
}
