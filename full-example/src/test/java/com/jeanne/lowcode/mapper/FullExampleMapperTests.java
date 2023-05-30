package com.jeanne.lowcode.mapper;

import com.jeanne.lowcode.entity.FullExample;
import com.jeanne.lowcode.service.BaseServiceTests;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.time.LocalTime;
import java.util.*;

//@MybatisPlusTest
@SpringBootTest
@Slf4j
class FullExampleMapperTests extends BaseServiceTests {

    @Autowired
    private FullExampleMapper sampleMapper;
    FullExample fullExample1 = readObjectFromJsonFile(FullExample.class, jsonFileDirectory + "full-example-1.json");
    QueryWrapper<FullExample> queryWrapper=new QueryWrapper();
    IPage<FullExample> page = new PageDTO<>();

    @Test
    void testInsert() {
        try {
//            fullExample1.setId(40l);
            sampleMapper.insert(fullExample1);
        } catch (DuplicateKeyException duplicateKeyException) {
            log.error("FullExampleMapperTests.testInsert encounters DuplicateKeyException:{}",duplicateKeyException);
        }
        log.info("ID===>{}",fullExample1.getId());
    }
    @Test
    void testUpdateById() {
        fullExample1.setId(54l);
        fullExample1.setNumberExample(2l);
        fullExample1.setTextAreaExample("<strong>aaaaa<strong> is approaching\n hello");
        sampleMapper.updateById(fullExample1);
    }
    @Test
    void testUpdate() {
        Date date = DateUtil.parse("2022-05-15 23:59:59");

        UpdateWrapper<FullExample> updateWrapper = Wrappers.update();
        updateWrapper.lambda()
                .set(FullExample::getTimeExample, LocalTime.now())
                .gt(FullExample::getCreateTime, date);

        fullExample1.setNumberExample(2l);
        fullExample1.setTextAreaExample("<strong>aaaaa<strong> is approaching\n hello");

        sampleMapper.update(fullExample1, updateWrapper);
    }
    @Test
    void testDeleteById() {
        sampleMapper.deleteById(40l);
    }
    @Test
    void testDeleteByMap() {
        HashMap criteriaMap = new HashMap();
        criteriaMap.put("id", 1l);

        int deleteCount = sampleMapper.deleteByMap(criteriaMap);
        System.out.println(deleteCount);
    }

    @Test
    void testDelete() {
        queryWrapper.le("id",10);
        sampleMapper.delete(queryWrapper);
    }

    @Test
    void testDeleteBatchIds() {
        int deletedCount = sampleMapper.deleteBatchIds(Arrays.asList(new Long[]{11l, 12l, 13l}));
        System.out.println(deletedCount);
    }

    @Test
    void testSelectById() {
        FullExample result = sampleMapper.selectById(21l);
        System.out.println(result);
    }

    @Test
    void testSelectBatchIds() {
        Long[] ids = new Long[]{11l,21l,22l,33l};
        List<FullExample> results = sampleMapper.selectBatchIds(Arrays.asList(ids));
        System.out.println(results);

    }

    @Test
    void testSelectByMap() {
        HashMap<String, Object> params = new HashMap<>();
        params.put("input_example","FieldFill example");

        List<FullExample> results = sampleMapper.selectByMap(params);
    }

    @Test
    void testSelectOne() {
        queryWrapper.gt("id",5).like("input_example","Field");

        try {
            sampleMapper.selectOne(queryWrapper);
        } catch (TooManyResultsException e) {
            log.error("TooManyResultsException ",e);
        }
    }

    @Test
    void testExists() {
        queryWrapper.gt("id",5).like("input_example","Field");
        sampleMapper.exists(queryWrapper);
    }

    @Test
    void testSelectCount() {
        queryWrapper.gt("id",5).like("input_example","Field");
        sampleMapper.selectCount(queryWrapper);
    }

    @Test
    void testSelectList() {
        queryWrapper.gt("id",5).like("input_example","Field");

        List<FullExample> results = sampleMapper.selectList(queryWrapper);
    }

    @Test
    void testSelectMaps() {
        queryWrapper.gt("id",5).like("input_example","Field");

        List<Map<String, Object>> maps = sampleMapper.selectMaps(queryWrapper);
        System.out.println(maps);

    }

    @Test
    void testSelectObjs() {
        /**
         * 根据 Wrapper 条件，查询全部记录
         * 注意： 只返回第一个字段的值
         */
        queryWrapper.gt("id",5).like("input_example","Field");

        List<Object> results = sampleMapper.selectObjs(queryWrapper);
        System.out.println(results);
    }

    @Test
    void testSelectPage() {
        page.setCurrent(3l);
        page.setSize(5l);
        queryWrapper.orderByDesc("id");
        IPage<FullExample> pagedResult = sampleMapper.selectPage(this.page, queryWrapper);
        System.out.println(pagedResult);
    }

    @Test
    void testSelectMapsPage() {
        IPage<Map<String, Object>> page2=new Page<Map<String, Object>>(1,5);

        IPage<Map<String, Object>> mapIPageResults = sampleMapper.selectMapsPage(page2, queryWrapper);
        System.out.println(mapIPageResults);
    }

    @Test
    void testSelectJoin(){
    }

}
