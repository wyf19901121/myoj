package waitnotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainThread {
    public static void main(String[] args) {
        WaitThread waitThread = new WaitThread();
        NotifyThread notifyThread = new NotifyThread(waitThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(waitThread);
        executorService.execute(notifyThread);
        
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        executorService.shutdownNow();
    }
}
