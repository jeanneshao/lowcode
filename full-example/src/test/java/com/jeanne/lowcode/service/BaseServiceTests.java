package com.jeanne.lowcode.service;

import com.jeanne.lowcode.entity.*;
import com.jeanne.lowcode.utils.StringUtils;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@SpringBootTest
@Slf4j
public class BaseServiceTests {


    public static JsonMapper jsonMapper = new JsonMapper();
    public static ObjectMapper objectMapper = new ObjectMapper();
    static {
        jsonMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        JsonSetter.Value customSetter = JsonSetter.Value.forValueNulls(Nulls.SKIP);
        jsonMapper.setDefaultSetterInfo(customSetter);

        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setDefaultSetterInfo(customSetter);
    }

    protected String jsonFileDirectory = "D:\\git\\unicom\\lowcode-backend\\src\\test\\java\\com\\asiainfo\\lowcode\\json\\";

    Class[] entityClasses = new Class[]{AssociationFullExampleToCascade.class, AssociationFullExampleToCog.class, AssociationFullExampleToEnum.class, AssociationFullExampleToFile.class, AssociationFullExampleToMany.class, CascademultiWithBackend.class, CascadeWithBackend.class, CogWithBackend.class, FullExample.class, LowcodeEnum.class, OneToManyExample.class, OneToOneExample.class, RogWithBackend.class, SelectWithBackend.class, UploadedFile.class};

    public void writeToJsonFile(Class clazz) {
        String jsonFilePath = jsonFileDirectory + StringUtils.camelToPascal(clazz.getSimpleName()) + ".json";
        Constructor declaredConstructor = null;
        try {
            declaredConstructor = clazz.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            Object targetObject = declaredConstructor.newInstance();

            objectMapper.writeValue(new File(jsonFilePath), targetObject);
        } catch (NoSuchMethodException e) {
            log.error("NoSuchMethodException===>", e.getMessage());
        } catch (InvocationTargetException e) {
            log.error("InvocationTargetException===>", e.getMessage());
        } catch (InstantiationException e) {
            log.error("InstantiationException===>", e.getMessage());
        } catch (IllegalAccessException e) {
            log.error("IllegalAccessException===>", e.getMessage());
        } catch (JsonMappingException jsonMappingException) {
            log.error("JsonMappingException===>", jsonMappingException.getMessage());
        } catch (JsonGenerationException e) {
            log.error("JsonGenerationException===>", e.getMessage());
        } catch (IOException e) {
            log.error("IOException===>", e.getMessage());
        }


    }

    public <T> T readObjectFromJsonFile(Class clazz) {
        String jsonFilePath = jsonFileDirectory + StringUtils.camelToPascal(clazz.getSimpleName()) + ".json";
        T targetObject = readObjectFromJsonFile(clazz, jsonFilePath);
        return targetObject;
    }
    public <T> T readObjectFromJsonFile(Class clazz,String jsonFilePath) {
        T targetObject = null;
        try {
            targetObject = (T) objectMapper.readValue(new File(jsonFilePath), clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return targetObject;
    }

    @Test
    void testWriteToJsonFile() {
        writeToJsonFile(FullExample.class);

    }

    @Test
    void writeAllEmptyToJsonFile() {
        for (Class entityClass : entityClasses) {
            writeToJsonFile(entityClass);
        }
    }

    @Test
    void testReadFromJsonFile() {
        FullExample fullExample11 = readObjectFromJsonFile(FullExample.class);
        log.info("{}", fullExample11);
    }


}
