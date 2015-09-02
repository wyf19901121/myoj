package javastudy;

public class Fibonacci implements Runnable {
    private static int count = 0;
    private final int id = count++;
    private int num;
    public Fibonacci(int num) {
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
    public void run() {
        System.out.println(id + " " + num + " " + getFibonacci(num));
    }
}

