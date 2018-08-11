package com.jz.multithread;

/**
 * @Author jiazhi
 * @Description
 * @Date 2018/7/24/024 22:08
 */
public class MyObject {

    public synchronized  void show1() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  synchronized  void show2(){
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        final MyObject m1 = new MyObject();

        Thread tr1 = new Thread(new Runnable() {
            public void run() {
               m1.show1();
            }
        });

        Thread tr2 = new Thread(new Runnable() {
            public void run() {
                m1.show2();
            }
        });
        tr1.start();
        tr2.start();
    }
}
