package ThreadPool;

/**
 * Created by Administrator on 2017/8/31.
 */
public class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在运行");
    }
}
