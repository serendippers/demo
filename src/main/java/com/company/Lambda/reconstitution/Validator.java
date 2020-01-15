package com.company.Lambda.reconstitution;

import java.util.function.Predicate;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class Validator {

    private Predicate<String> predicate;

    public Validator(Predicate<String> predicate) {
        this.predicate = predicate;
    }

    public boolean validator(String s) {
        return predicate.test(s);
    }
}
