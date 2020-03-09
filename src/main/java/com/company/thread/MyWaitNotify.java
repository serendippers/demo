package com.company.thread;

/**
 * @author ZhangPengPeng
 * @date 2019/3/21 15:11
 */
public class MyWaitNotify {

    private  MonitorObject monitorObject = new MonitorObject();

    public void doWait() {
        synchronized (monitorObject) {
            try {
                monitorObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void doNotify() {
        synchronized (monitorObject) {
            monitorObject.notify();
        }
    }
}
