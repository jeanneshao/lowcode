package com.jeanne.lowcode.service;

import com.jeanne.lowcode.entity.LowcodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class LowCodeEnumServiceTests extends BaseServiceTests {

    @Autowired
    LowcodeEnumService service;
    List<LowcodeEnum> genderEnums;
    List<LowcodeEnum> billingFlags;

    {
        genderEnums = readObjectFromJsonFile(List.class,"D:\\git\\unicom\\lowcode-backend\\src\\test\\java\\com\\asiainfo\\lowcode\\json\\lowcode-enum-gender.json");
        billingFlags = readObjectFromJsonFile(List.class,"D:\\git\\unicom\\lowcode-backend\\src\\test\\java\\com\\asiainfo\\lowcode\\json\\lowcode-enum-billing-flag.json");
    }

    @Test
    void testSave() {
//        service.save(genderEnum);
    }

    @Test
    void testSaveAll(){
        boolean result = service.saveBatch(genderEnums);
    }

    @Test
    void testQueryAll(){
//        List<LowcodeEnum> lowcodeEnumList = service.list();
//        LowcodeEnum maleGender = objectMapper.convertValue(genderEnums.get(0), LowcodeEnum.class);
//        maleGender.setId(4l);
//        maleGender.setLabel("Male");
////        service.updateById(maleGender);// 未清缓存
//        LowcodeEnum prepaidBillingFlag = objectMapper.convertValue(billingFlags.get(0), LowcodeEnum.class);
////
//        service.save(prepaidBillingFlag);
       service.list();


//        service.saveBatch(billingFlags);
        System.out.println("1");
    }
    @Test
    void testUpdate(){


//        service.saveOrUpdate(fullExample);
//        service.save(fullExample);

    }

}
