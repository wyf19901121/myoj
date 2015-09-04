package waitnotify;

public class WaitThread implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            while (!Thread.interrupted()) {
                System.out.println("I will wait");
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        // TODO Auto-generated method stub
        
    }
}
