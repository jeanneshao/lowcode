package com.jeanne.lowcode.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.jeanne.lowcode.common.annotations.LowcodeAssociation;
import com.jeanne.lowcode.common.response.PaginationVo;
import com.jeanne.lowcode.vo.SearchMeta;
import com.jeanne.lowcode.vo.TextSearchVo;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Jeanne 2023/5/24
 **/
@Data
@Builder
@Slf4j
@Component
public class LowcodeQueryHelper {

    public static <T> QueryWrapper<T> addOrdersToQueryWrapper(String source, QueryWrapper<T> queryWrapper) {
        log.info("addOrdersToQueryWrapper=====>{}", source);
        if (!StringUtils.hasText(source)) return queryWrapper;

        //e.g. id:asc,name:desc
        String[] sortProperties = source.split(",");
        Arrays.stream(sortProperties).forEach(sortProperty -> {
            if (!StringUtils.hasText(sortProperty)) return;

            String[] sortPropertyAndAsc = sortProperty.split(":");
            String property = sortPropertyAndAsc[0];
            boolean asc = sortPropertyAndAsc.length == 2 ? sortPropertyAndAsc[1].equalsIgnoreCase("ASC") : true;

            if (asc) {
                queryWrapper.orderByAsc(property);
            } else {
                queryWrapper.orderByDesc(property);
            }
        });


        return queryWrapper;
    }

    public static <T> IPage<T> convertPagination(PaginationVo paginationVo) {
        IPage<T> page = new PageDTO<>();
        page.setCurrent(paginationVo.getPage() - 1);
        page.setSize(paginationVo.getRowsPerPage());
        return page;
    }


    public static <T> QueryWrapper<T> obtainCriteria(String sortProperties, TextSearchVo textSearchVo, Class searchVoClazz) {
        QueryWrapper<T> queryWrapper = new QueryWrapper();

        queryWrapper = LowcodeQueryHelper.addOrdersToQueryWrapper(sortProperties, queryWrapper);

        log.info("text search===>{}", textSearchVo);
        Map<String, Object> fieldsDefinitions = new HashMap<>();

        final Field[] declaredFields = searchVoClazz.getDeclaredFields();
        Map<String, SearchMeta> searchMetaMap = Arrays.stream(declaredFields).collect(Collectors.toMap(Field::getName, LowcodeQueryHelper::getFieldSearchMeta));

        textSearchVo.getSearchIemList().forEach(searchIem -> {
            log.info("<=====convert search item==", searchIem);
            Optional.ofNullable(searchMetaMap.get(searchIem.getField())).ifPresent(searchMeta -> {
                searchIem.getOperator();
                searchIem.getParams();
                // 数据参数的数据类型
                Class fieldType = searchMeta.getType();
                if (fieldType == Integer.class || fieldType == Short.class) {

                } else if (fieldType == Boolean.class) {

                } else if (fieldType == Long.class) {

                } else if (fieldType == Double.class || fieldType == Float.class) {

                }


            });


        });


        return queryWrapper;
    }

    public static Map beanToMap(Object object) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (object != null) {
            BeanMap beanMap = BeanMap.create(object);
            for (Object key : beanMap.keySet()) {
                Object value = beanMap.get(key);
                Optional.ofNullable(value).ifPresent(v -> {
                    log.debug("key====>{}<=====>value======>{}", key, value);
                    map.put(key + "", value);
                });
            }
        }
        return map;
    }

    public static SearchMeta getFieldSearchMeta(Field field) {
        SearchMeta searchMeta = SearchMeta.builder()
                .fieldName(field.getName())
                .type(field.getType())
                .associationColumn(field.isAnnotationPresent(LowcodeAssociation.class))
                .rawField(field)
                .build();

        return searchMeta;
    }

}
