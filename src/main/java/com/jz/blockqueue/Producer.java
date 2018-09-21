package com.jz.blockqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author jiazhi
 * @Description
 * @Date 2018/9/21 11:20
 */
public class Producer implements  Runnable {

    private  volatile  boolean isRunning = true;

   private BlockingQueue  blockingQueue;

   private static AtomicInteger count = new AtomicInteger();

   private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    public Producer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
       String data  = null;
        Random random = new Random();

        System.out.println("启动生产者线程！");

        while (isRunning){
            System.out.println("正在生产数据...");
            try {
             //   Thread.currentThread().sleep(random.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                data = "data:" + count.incrementAndGet();
                System.out.println("将数据"+data+"放入队列...");
                if(!blockingQueue.offer(data,2, TimeUnit.MILLISECONDS)){
                    System.out.println("放入数据失败：" +data);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void stop(){
        isRunning = false;
    }
}
