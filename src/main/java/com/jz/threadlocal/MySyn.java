package com.jz.threadlocal;

/**
 * @Author jiazhi
 * @Description
 * @Date 2018/7/4/004 22:08
 */
public class MySyn {

    private  static final ThreadLocal<Student>  trl = new ThreadLocal<Student>();

    public void set(Student stu){
        trl.set(stu);
    }

    public void show(){
        System.out.println(Thread.currentThread().getName() + ": "+trl.get().toString());
    }
}
