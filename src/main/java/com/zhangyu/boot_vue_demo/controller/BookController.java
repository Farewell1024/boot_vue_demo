package com.zhangyu.boot_vue_demo.controller;

import com.zhangyu.boot_vue_demo.domain.Book;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    /**
     * CrossOrigin  细粒度的跨域配置，value：支持来自何方的跨域请求；maxAge:探测请求的有限期；allowedHeaders：允许的请求头
     *
     */
//    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    @GetMapping("/get")
    public Book get(){
        int i = 1/ 0 ;
        return Book.builder().id(1).name("Thinking in Java").author("张宇").time(new Date()).build();
    }

    /**
     如果Get请求相同的中多个参数具有相同的字段名称，在请求时无法进行区分，则可以使用@ModelAttribute 指定前缀，
     前缀的设置在GlobalExceptionController类中@InitBinder注解所修饰方法中
     */
    @GetMapping("/book")
    public String book(@ModelAttribute("b") Book book){
        return book.toString();
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile uploadFiles){
        System.out.println("success");
        return "Success ! ";
    }

}
