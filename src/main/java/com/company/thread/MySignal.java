package com.company.thread;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class MySignal {

    //通过共享对象通信
    protected boolean hasDataToProcess = false;

    public synchronized boolean hasDataToProcess() {
        return hasDataToProcess;
    }

    public synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        this.hasDataToProcess = hasDataToProcess;
    }
}
