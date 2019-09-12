package com.zhangyu.boot_vue_demo.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

/**
 * Function:
 *
 * @author zhangyu
 * Date: 2019/9/12 16:08
 * @since JDK 1.8
 */
@Data
@Builder
public class Book {
    private Integer id;

    private String name;

    private String author;

    private Date time;
}
