package com.company.Lambda.reconstitution;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class Test {

    //public  void doSomething(Runnable r){ r.run(); }
    public  void doSomething(Task a){ a.execute(); }
}
