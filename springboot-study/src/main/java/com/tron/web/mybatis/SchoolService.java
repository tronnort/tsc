package com.tron.web.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    private SchoolMapper schoolMapper;

}
