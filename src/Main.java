import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        example2();


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
}