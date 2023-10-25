import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        example2();


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
}