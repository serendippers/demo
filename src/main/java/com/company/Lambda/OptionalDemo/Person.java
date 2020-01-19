package com.company.Lambda.OptionalDemo;

import java.util.Optional;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class Person {

    private Optional<Car> car;

    private Integer age;

    public Optional<Car> getCar() {
        return car;
    }

    public Integer getAge() {
        return age;
    }
}
