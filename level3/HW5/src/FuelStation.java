import garage.Cars;
///pull
import java.util.concurrent.Semaphore;

public class FuelStation {
    Semaphore sm;

    FuelStation() {

        sm = new Semaphore(3);

    }

    public void fillTheCar(Cars c) {

        try {
            System.out.println(String.format("The %s arrived at the fuel station", c.getName()));
            sm.acquire();
            System.out.println(String.format("%s refueling", c.getName()));
            Thread.sleep(5000);
            c.writeFuelTank(c.getMaxFuelTank());
            System.out.println(String.format("%s fuel tank full!!!", c.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sm.release();
        }
    }
}

