package com.jeanne.lowcode.searchservice.aspect.aspectj;

import com.jeanne.lowcode.searchservice.service.CommonPointcuts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * @author Jeanne 2023/5/30
 **/
@Configurable()
public class Account {
    @Autowired // @Inject
    CommonPointcuts commonPointcuts;
    public void printCommonPointcuts(){
        commonPointcuts.dataAccessOperation(3,"44");
    }
}
