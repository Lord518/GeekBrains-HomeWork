public class PrintABC {
    char c = 'A';
//PUll
    public synchronized void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                while (c == 'B' || c == 'C') {
                    wait();
                }
                System.out.print(c);
                c = 'B';
                notifyAll();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public synchronized void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                while (c == 'A' || c == 'C') {
                    wait();
                }
                System.out.print(c);
                c = 'C';
                notifyAll();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public synchronized void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                while (c == 'A' || c == 'B') {
                    wait();
                }
                System.out.print(c);
                c = 'A';
                notifyAll();
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
