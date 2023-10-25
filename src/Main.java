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
                imitateWork(x);         //�������� ��������� ���� ����������� �����
            }
        });
        thread1.start();
        Thread thread2 = new Thread(()->{  imitateWork(y); });      //������ ��������� ��� ���������
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
        SillyWorker w1 = new SillyWorker("�������", 7);
        SillyWorker w2 = new SillyWorker("������", 5);

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
        LazyWorker worker1 = new LazyWorker("������� ��������");
        LazyWorker worker2 = new LazyWorker("������");
        worker1.doWork(3);  //������� �������� ���������������,
        worker2.doWork(5);  //� �� �����������

        worker1.run();      //���� �����, ����� �� �����
        worker2.run();
        System.out.println("-----------------------------");
        worker1.start();
        worker2.start();
        System.out.println("======= ��� �������� =========");
        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("++++++++ ��������� +++++++++++");
    }

    private static void example1() throws InterruptedException {
        System.out.println("Hello world!");
        sleep(1000);
        System.out.println("� ���������!");
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