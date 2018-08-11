package com.jz.threadlocal;

import com.jz.multithread.MyThead;

/**
 * @Author jiazhi
 * @Description
 * @Date 2018/7/4/004 22:11
 */
class  MyThread  implements  Runnable{
   private  MySyn stu;

   public MyThread(MySyn st){
       this.stu = st;
   }

    public void setStu(MySyn st){
        this.stu = st;
    }
    public void run() {

        stu.show();
    }
}

public class ThreadLocalTest {

    public static void main(String[] args) throws InterruptedException {

       final MySyn my = new MySyn();


        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                 my.set(new Student("11","22"));
                 my.show();
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            public void run() {
               // my.set(new Student());
                my.show();
            }
        });
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
    }


}
