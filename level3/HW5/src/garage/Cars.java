package garage;
///pull
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cars implements Runnable {
    private String name;
    private double maxFuelTank;
    private double fuelTank;
    private double fuelConsumption;
    private double fuelConsumptionMetre;
    ReentrantReadWriteLock lock;

    Cars(String name, double fuelTank, double fuelConsumption) {
        this.name = name;
        this.fuelTank = fuelTank;
        this.fuelConsumption = fuelConsumption;
        this.fuelConsumptionMetre = fuelConsumption / 1000;
        lock = new ReentrantReadWriteLock();
        maxFuelTank = fuelTank;
        run();
    }


    public double getMaxFuelTank() {
        return maxFuelTank;
    }

    public String getName() {
        return name;
    }

    public double readFuelTank() {
        try {
            lock.readLock().lock();
            return fuelTank;
        } finally {
            lock.readLock().unlock();
        }

    }

    public void writeFuelTank(double fTank) {
        try {
            lock.writeLock().lock();
            fuelTank = fTank;
        } finally {
            lock.writeLock().unlock();
        }

    }

    public void go() {
        ///имитация расхода топлива
        for (double i = fuelTank; i > fuelConsumptionMetre; i = i - fuelConsumptionMetre) {
            try {
                Thread.sleep(10);
                writeFuelTank(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void fuelCheck() {
        ///проверка бака,вывод остатка
        while (readFuelTank() > 0.1) {
            try {
                Thread.sleep(3000);
              //  System.out.println(String.format("%s fuel left %2f ", name, readFuelTank()));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(String.format("%s no fuel left!!!",getName()));
    }


    @Override
    public void run() {
        System.out.println(String.format("The %s go!!!", name));
        new Thread(() -> go()).start();
        new Thread(() -> fuelCheck()).start();
    }
}
