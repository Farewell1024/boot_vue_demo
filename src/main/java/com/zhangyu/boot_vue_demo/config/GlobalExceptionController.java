package com.zhangyu.boot_vue_demo.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2019/9/16 10:27
 * @since JDK 1.8
 */
@RestControllerAdvice
public class GlobalExceptionController {

    @InitBinder("b")
    public void init1(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("b.");
    }



    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String maxUploadSizeExceededException(MaxUploadSizeExceededException e){
        return "上传异常！";
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String exception(Exception e) {
        return "服务器打了个盹！";
    }

}
