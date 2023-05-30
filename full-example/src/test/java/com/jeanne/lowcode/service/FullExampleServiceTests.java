package com.jeanne.lowcode.service;

import com.jeanne.lowcode.entity.FullExample;
import com.jeanne.lowcode.entity.LowcodeEnum;
import com.jeanne.lowcode.mapper.FullExampleMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@SpringBootTest
@Slf4j
class FullExampleServiceTests extends BaseServiceTests {

    @Autowired
    FullExampleService service;
    FullExample fullExample = new FullExample();
    List<FullExample> fullExamples;
    List<LowcodeEnum> billingFlags;
    @Autowired
    FullExampleMapper fullExampleMapper;

    {
        fullExamples = readObjectFromJsonFile(List.class, "D:\\git\\unicom\\lowcode-backend\\src\\test\\java\\com\\asiainfo\\lowcode\\json\\full-examples.json");
    }

    // todo: 单个保存 新增/修改
    // todo: 批量新增 新增/修改
    // todo: 批量修改
    // todo: 分页查询

    /**
     * 1:1, 1:n, n:1 关联关系直接在n表里加1表主键 -- 相当于外键
     * n:n 增加了关联表
     */
    // todo: 建立关联关系
    // todo: 删除关联关系
    // todo: 新增关联实体并建立关联关系


    @Test
    void testSaveOne() {

        UpdateWrapper<FullExample> updateWrapper = Wrappers.update();
        updateWrapper.lambda()
                .set(FullExample::getTimeExample, LocalTime.now())
                .eq(FullExample::getId, 41l);

        service.update(updateWrapper);
    }

    @Test
    void testSaveOrUpdate() {
        fullExample.setId(22l);
        fullExample.setInputExample("input test " + System.currentTimeMillis());
        fullExample.setDateTimeExample(LocalDateTime.now());
        service.saveOrUpdate(fullExample);
//        service.saveBatch(fullExamples);
    }

    @Test
    void testSelectCount() {
        QueryWrapper<FullExample> queryWrapper=new QueryWrapper();
        queryWrapper.gt("id",5).like("input_example","Field");
        log.info("<==========================testSelectCount:{}",fullExampleMapper.selectCount(queryWrapper));

    }

    @Test
    void testPagination(){

        QueryWrapper<FullExample> queryWrapper=new QueryWrapper();
        IPage<FullExample> page = new PageDTO<>();
        IPage<FullExample> page2 = fullExampleMapper.selectPage(page, queryWrapper);
        System.out.println(page2);
    }


    @Test
    @Transactional
    /**
     * 单元测试@TransActional注解会自动回滚，
     * 会自动带有@Rollback(true)
     * 如果需要修改数据库就不要使用@TransActional注解或者添加@Rollback(flase)”
     */
    void testUpdate() {
        UpdateWrapper<FullExample> updateWrapper = Wrappers.update();
   /*
      // 没有加乐观锁逻辑
        updateWrapper.lambda()
                .set(FullExample::getTimeExample,LocalTime.now())
                .eq(FullExample::getId,3l) ;
        fullExampleMapper.update(null, updateWrapper);
        */

        FullExample fullExampleOptimisticLock = fullExampleMapper.selectById(3l);
        fullExampleOptimisticLock.setInputExample("OptimisticLock test1");
        int updateCount1 = fullExampleMapper.updateById(fullExampleOptimisticLock);
        log.info("1st update===>updateCount:{},NumberExample: {}", updateCount1, fullExampleOptimisticLock.getNumberExample());

        fullExampleOptimisticLock.setInputExample("OptimisticLock test2");
//        fullExampleOptimisticLock.setNumberExample(fullExampleOptimisticLock.getNumberExample()+1);
        int updateCount2 = fullExampleMapper.updateById(fullExampleOptimisticLock);
        log.info("1st update===>updateCount:{},NumberExample: {}", updateCount2, fullExampleOptimisticLock.getNumberExample());

        fullExampleOptimisticLock.setInputExample("OptimisticLock test3");
        fullExampleOptimisticLock.setNumberExample(fullExampleOptimisticLock.getNumberExample() + 1);
        int updateCount3 = fullExampleMapper.updateById(fullExampleOptimisticLock);
        log.info("1st update===>updateCount:{},NumberExample: {}", updateCount3, fullExampleOptimisticLock.getNumberExample());
    }

    @Test
    void testQueryAll() {
        List<FullExample> entityList = service.list();
        System.out.println("<==================number example============================>");
        entityList.stream().map(FullExample::getNumberExample).forEach(System.out::println);
        System.out.println("<==================double example============================>");
        entityList.stream().map(FullExample::getDoubleExample).forEach(System.out::println);
        System.out.println("<==================end============================>");
    }

}
