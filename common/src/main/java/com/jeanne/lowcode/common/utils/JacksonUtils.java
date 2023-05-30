package com.jeanne.lowcode.common.utils;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Jeanne 2023/5/24
 **/
@Slf4j
public class JacksonUtils {

    public static JsonMapper jsonMapper = new JsonMapper();
    public static ObjectMapper objectMapper = new ObjectMapper();
    static {
        jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JsonSetter.Value customSetter = JsonSetter.Value.forValueNulls(Nulls.SKIP);
        jsonMapper.setDefaultSetterInfo(customSetter);

        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setDefaultSetterInfo(customSetter);
    }

    public static String writeValueAsString(Object object){
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("writeValueAsString encounters error",e);
        }
        return "";
    }
}
