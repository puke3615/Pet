package com.puke.pet.entity;

import lombok.Data;

/**
 * @author zijiao
 * @version 18/4/20
 */
@Data
public class Dog {

    private Long id;
    private String name;
    private Integer age;
    private Integer sex;
    private String type;

}
