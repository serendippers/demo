package com.company.Lambda.reconstitution;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class Main {

    public static void main(String[] args) {
       /* Test test = new Test();
        test.doSomething(()-> System.out.println("123"));*/

       Validator validator = new Validator((s -> s.matches("\\d+")));
    }
}
