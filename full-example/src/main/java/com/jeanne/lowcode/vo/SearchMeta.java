package com.jeanne.lowcode.vo;

import com.baomidou.mybatisplus.core.conditions.interfaces.Compare;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Jeanne 2023/5/25
 **/
@Builder
@Data
@Slf4j
public class SearchMeta {
    String fieldName;
    Class type;
    Boolean associationColumn;
    Field rawField;

    public <T> void convertCriteria(QueryWrapper<T> queryWrapper, Object complexSearchString){
        // e.g. name = eq,ss,in,aaa,bbb
        // name = ss and name in ('aaa','bbb')
        Class queryWrapperClass = Compare.class;

        Method[] declaredMethods = queryWrapperClass.getDeclaredMethods();
        Map<String, Method> queryWrapperMethodMap = Arrays.stream(declaredMethods)
                .collect(
                        Collectors.toMap(
                                Method::getName,
                                method -> method,
                                (oldValue, newValue) -> { // 处理键重复的情况
                                    return oldValue;
                                })
                );

        Method currentMethod = null;
        ArrayList<String> params = new ArrayList<>();
        if (complexSearchString instanceof String) {
            String[] complexSearchSplit = ((String) complexSearchString).split(",");
            for (String s : (String[]) complexSearchSplit) {
                Method wrapperMethod = queryWrapperMethodMap.get(s);
                if (Optional.ofNullable(wrapperMethod).isEmpty()) {
                    log.info("<=====convertCriteria==={}===>is param", s);
                    //当前是参数
                    params.add(s);
                } else {
                    log.info("<=====convertCriteria==={}===>is operator", s);
                    //当前是操作符
                    if(currentMethod == null){
                        currentMethod= wrapperMethod;
                        continue;
                    }

                    try {
                        Class<?>[] parameterTypes = currentMethod.getParameterTypes();
                        System.out.println(parameterTypes);

                        currentMethod.invoke(queryWrapper,params);
                    } catch (IllegalAccessException e) {
                        log.error("convertCriteria encounters IllegalAccessException",e);
                    } catch (InvocationTargetException e) {
                        log.error("convertCriteria encounters InvocationTargetException",e);
                    } finally {
                        currentMethod= wrapperMethod;
                        params.clear();
                    }


                }

            }
            if(currentMethod!=null)   {
                try {
                    currentMethod.invoke(queryWrapper,params);
                } catch (IllegalAccessException e) {
                    log.error("convertCriteria encounters IllegalAccessException",e);
                } catch (InvocationTargetException e) {
                    log.error("convertCriteria encounters InvocationTargetException",e);
                } finally {
                    params.clear();
                }
            }
        }


    }

}