package com.tron.web.service.impl;

import com.tron.web.entity.Dept;
import com.tron.web.mapper.DeptMapper;
import com.tron.web.service.IDeptService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tron
 * @since 2019-10-19
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

}
