package com.jeanne.lowcode.service.impl;

import com.jeanne.lowcode.entity.OneToManyExample;
import com.jeanne.lowcode.mapper.OneToManyExampleMapper;
import com.jeanne.lowcode.service.OneToManyExampleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 一对多的关联表 服务实现类
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Service
public class OneToManyExampleServiceImpl extends ServiceImpl<OneToManyExampleMapper, OneToManyExample> implements OneToManyExampleService {

}
