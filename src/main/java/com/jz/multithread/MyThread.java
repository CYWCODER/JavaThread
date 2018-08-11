package com.jz.multithread;

/**
 * @Author jiazhi
 * @Description
 * @Date 2018/7/24/024 21:04
 */
public class MyThread  extends  Thread{

    private int count = 5;

    /**
     * 不加synchronized ，输出的结果都是0，
     */
    @Override
    public synchronized  void run() {
        count--;
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "count=" + count);
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread t1 =  new Thread(myThread,"t1");
        Thread t2 =  new Thread(myThread,"t2");
        Thread t3 =  new Thread(myThread,"t3");
        Thread t4 =  new Thread(myThread,"t4");
        Thread t5 =  new Thread(myThread,"t5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
