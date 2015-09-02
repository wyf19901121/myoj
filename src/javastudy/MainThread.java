package javastudy;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MainThread {
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(new Fibonacci(i));
//            t.start();
//        }
//        ExecutorService exec = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            exec.execute(new Fibonacci(i));
//        }
//        exec.shutdown();
////        exec.execute(new Fibonacci(12));
//    }
//    public static void main(String[] args) {
//        ExecutorService exec = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//            exec.execute(new Fibonacci(i));
//        }
//    }
//    public static void main(String[] args) {
//        ExecutorService exec = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 10; i++) {
//            exec.execute(new Fibonacci(i));
//        }
//        exec.shutdown();
//    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<String>> res = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            res.add(exec.submit(new CallableFibonacci(i)));
        }
        for (Future<String> future : res) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
                // TODO: handle exception
            } catch (ExecutionException e) {
                System.out.println(e);
                return;
                // TODO: handle exception
            } finally {
                exec.shutdown();
            }
        }

    }
}
