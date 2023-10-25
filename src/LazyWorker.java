public class LazyWorker extends Thread{
    String name;

    public LazyWorker(String name) {
        this.name = name;
    }

    public void doWork(int k){
        try {
            for (int i = 0; i < k; i++) {
                sleep(500);
                System.out.println(name+": "+i);
            }
        } catch (InterruptedException e) {
            System.out.println("меня прервали");
        }
    }

    @Override
    public void run() {
        //
        doWork(5);
    }
}
