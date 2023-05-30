package com.jeanne.lowcode.controller;

import com.jeanne.lowcode.common.response.BizResponse;
import com.jeanne.lowcode.common.response.CodeMsg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 一对一的关联表 前端控制器
 * </p>
 *
 * @author Jeanne
 * @since 2023-05-07 05:31:47
 */
@Controller
@RequestMapping("/oneToOneExample")
public class OneToOneExampleController extends BaseEntityController {

    @ExceptionHandler({Exception.class})
    public BizResponse fix(Exception ex){
        return BizResponse.error(CodeMsg.GOODS_ADD_BRAND_ERROR);
    }

    @GetMapping(path = "/err")
    public BizResponse stimulateError() {
        int result = 100/0;
        return BizResponse.success(result);
    }
}
