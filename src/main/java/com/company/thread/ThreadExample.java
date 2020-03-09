package com.company.thread;

import org.omg.CORBA.LocalObject;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class ThreadExample {

    public static void main(String[] args) {
        /*System.out.println(Thread.currentThread().getName());

        for (int i = 0; i < 10; i++) {
            new Thread("" + i) {
                @Override
                public void run() {
                    System.out.println("Thread: " + getName() + "running");
                }
            }.start();
        }*/
        ThreadExample threadExample = new ThreadExample();
        threadExample.someMethod();
    }

    public void someMethod() {
        Local local = new Local();
        methid(local);
        System.out.println(local);
    }

    public void methid(Local local) {
        local.setValue("test");
    }

    class Local{
        String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Local{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
