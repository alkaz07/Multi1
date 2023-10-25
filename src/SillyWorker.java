import static java.lang.Thread.sleep;

public class SillyWorker implements Runnable {
    String name;
    int kolvo=1;

    public SillyWorker(String name, int kolvo) {
        this.name = name;
        this.kolvo = kolvo;
    }

    public SillyWorker(String name) {
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
        doWork(kolvo);
    }
}
