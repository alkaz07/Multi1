import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //  example2();
        //example3();
        example4();

    }

    private static void example4() {
        int x=4, y=7;
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                imitateWork(x);         //вызываем описанный ниже статический метод
            }
        });
        thread1.start();
        Thread thread2 = new Thread(()->{  imitateWork(y); });      //лямбда выражение для краткости
        thread2.start();
        System.out.println("----- start ---------");
        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException ex){}
        System.out.println("+++++ finish ++++++++");

    }

    private static void example3() {
        SillyWorker w1 = new SillyWorker("Штирлиц", 7);
        SillyWorker w2 = new SillyWorker("Бендер", 5);

        Thread thread1 = new Thread(w1);
        thread1.start();
        Thread thread2 = new Thread(w2);
        thread2.start();
        System.out.println("----- start ---------");
        try {
            thread1.join();
            thread2.join();
        }
        catch (InterruptedException ex){}
        System.out.println("+++++ finish ++++++++");
    }

    private static void example2() {
        LazyWorker worker1 = new LazyWorker("Василий Иванович");
        LazyWorker worker2 = new LazyWorker("Петька");
        worker1.doWork(3);  //объекты работают последовательно,
        worker2.doWork(5);  //а не параллельно

        worker1.run();      //тоже самое, лучше не стало
        worker2.run();
        System.out.println("-----------------------------");
        worker1.start();
        worker2.start();
        System.out.println("======= без ожидания =========");
        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("++++++++ дождались +++++++++++");
    }

    private static void example1() throws InterruptedException {
        System.out.println("Hello world!");
        sleep(1000);
        System.out.println("я проснулся!");
        for (int i = 0; i < 7; i++) {
            sleep(500);
            System.out.println(i);
        }
    }

    public static void imitateWork(int k)
    {
        for (int i = 0; i < k; i++) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(currentThread()+": "+i);
        }
    }
}