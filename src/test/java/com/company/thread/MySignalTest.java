package com.company.thread;

import org.junit.jupiter.api.Test;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class MySignalTest {

    @Test
    public void test1() {
        MySignal mySignal = new MySignal();


        while (mySignal.hasDataToProcess()) {

        }
    }
}
