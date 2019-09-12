package com.zhangyu.boot_vue_demo.controller;

import com.zhangyu.boot_vue_demo.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2019/9/12 17:54
 * @since JDK 1.8
 */
@RestController
public class BookController {

    @GetMapping("/get")
    public Book get(){
        return Book.builder().id(1).name("Thinking in Java").author("张宇").time(new Date()).build();
    }

}
