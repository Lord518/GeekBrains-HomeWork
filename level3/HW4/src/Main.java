public class Main {

    public static void main(String[] args) {
        PrintABC abc = new PrintABC();
        new Thread(()->{abc.printA();}).start();
        new Thread(()->{abc.printB();}).start();
        new Thread(()->{abc.printC();}).start();

    }

}
