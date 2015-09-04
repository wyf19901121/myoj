package waitnotify;

public class NotifyThread implements Runnable {
    private WaitThread waitThread;
    public NotifyThread(WaitThread waitThread) {
        this.waitThread = waitThread;
        // TODO Auto-generated constructor stub
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (!Thread.interrupted()) {
            synchronized (waitThread) {
                waitThread.notifyAll();
            }
        }
    }
}
