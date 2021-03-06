package first;

import java.util.Scanner;

/**
 * Created by zhangxuelong on 2018/9/28
 */
public class Volatile implements Runnable {
    private static volatile boolean flag = true;

    @Override
    public void run() {
        while (flag) {
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }

    public static void main(String[] args) throws InterruptedException {
        Volatile aVolitle = new Volatile();
        new Thread(aVolitle, "thread A").start();
        System.out.println("main 线程正在运行");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String value = sc.next();
            if (value.equals("1")) {
                new Thread(aVolitle::stopThread).start();
                break;
            }
        }
        System.out.println("主线程退出了！");
    }

    private void stopThread() {
        flag = false;
    }
}
