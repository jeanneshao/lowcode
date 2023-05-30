package com.jeanne.lowcode.common.exception;

import com.jeanne.lowcode.common.response.BizResponse;
import com.jeanne.lowcode.common.response.CodeMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//@ControllerAdvice  // 切面
//@ResponseBody
@RestControllerAdvice // 等于 @ControllerAdvice+@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public BizResponse<String> exceptionHandler(HttpServletRequest request, Exception e) {
        logger.error("exceptionHandler error: ", e);
        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return BizResponse.error(ex.getCm());
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            return BizResponse.error(CodeMsg.BIND_ERROR.fillArgs(msg));
        } else {
            return BizResponse.error(CodeMsg.SERVER_ERROR);
        }
    }


}
