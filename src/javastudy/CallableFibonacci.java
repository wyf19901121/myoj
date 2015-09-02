package javastudy;

import java.util.concurrent.Callable;

public class CallableFibonacci implements Callable<String> {
    private static int count = 0;
    private final int id = count++;
    private int num;
    public CallableFibonacci(int num) {
        this.num = num;
        // TODO Auto-generated constructor stub
    }
    public int getFibonacci(int num) {
        if (num <= 1) {
            return num;
        }
        Thread.yield();
        return getFibonacci(num - 1) + getFibonacci(num - 2);
    }
    public String call() {
        return id + " " + num + " " + getFibonacci(num);
    }
}
