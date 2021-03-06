import java.util.Arrays;

public class ThreadArray {
    private static final int size = 10000000;
    private static final int h = size / 2;
    private float[] arr = new float[size];
    private float[] halfA = new float[h];
    private float[] halfB = new float[h];

    ThreadArray() {
        Arrays.fill(arr, 1);
    }

    public void offPerformance() {
        long start = System.currentTimeMillis();

        Thread t = new Thread(() -> changeValue(arr));
        t.start();
        while (t.isAlive()) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long finish = System.currentTimeMillis() - start;
        System.out.println(finish);
    }

    public void onPerformance() {
        long start = System.currentTimeMillis();
        System.arraycopy(arr, 0, halfA, 0, h);
        System.arraycopy(arr, h, halfB, 0, h);
        Thread t = new Thread(() -> {
            synchronized (halfA) {
                changeValue(halfA);
            }
        });
        Thread t1 = new Thread(() -> {
            synchronized (halfB) {
                changeValue(halfB);
            }
        });
        t.start();
        t1.start();

        try {
            t.join();
          t1.join();
         } catch (InterruptedException e) {
           e.printStackTrace();
        }
       complete(halfA,halfB,start);

    }
    private void complete(float [] halfA,float [] halfB,long start ) {
        synchronized (halfA) {
            synchronized (halfB) {
                System.arraycopy(halfA, 0, arr, 0, h);
                System.arraycopy(halfB, 0, arr, h, h);
                long finish = System.currentTimeMillis() - start;
                System.out.println(finish);
            }
        }
    }

    public void changeValue(float[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = (float) (a[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }


}
