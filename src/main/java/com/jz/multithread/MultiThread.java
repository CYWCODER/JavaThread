package com.jz.multithread;

/**
 * @Author jiazhi
 * @Description
 * @Date 2018/7/24/024 21:33
 */
public class MultiThread {

    private static  int num = 0;

    public static synchronized void setNum(String tag){
        try {
            if("a".equals(tag)){
                num = 100;
                System.out.println("tag="+tag +"num=" + num);
                Thread.currentThread().sleep(3000);

            }else {
                num = 200;
                System.out.println("tag="+tag +"num=" + num);
            }
            System.out.println("tag="+tag +"set num over");
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final MultiThread multiThread1  = new MultiThread();
        final MultiThread multiThread2  = new MultiThread();

        Thread trd1 = new Thread(new Runnable() {
            public void run() {
                multiThread1.setNum("a");
            }
        });

        Thread trd2 = new Thread(new Runnable() {
            public void run() {
                multiThread2.setNum("b");
            }
        });

        trd1.start();
        trd2.start();
    }


}
