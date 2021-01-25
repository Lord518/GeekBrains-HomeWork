import garage.Bus;
import garage.Car;
import garage.Truck;
///pull
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {

    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(()->fuelStation.fillTheCar(new Car("Toyota Prius")));
        executorService.execute(()->fuelStation.fillTheCar(new Bus("Icarus l300")));
        executorService.execute(()->fuelStation.fillTheCar(new Bus("Pazik")));
        executorService.execute(()->fuelStation.fillTheCar(new Car("BMW 525")));
        executorService.execute(()->fuelStation.fillTheCar(new Truck("MAN 640")));
        executorService.execute(()->fuelStation.fillTheCar(new Truck("Iveco ")));
        executorService.execute(()->fuelStation.fillTheCar(new Car("Toyota Camry")));
        executorService.execute(()->fuelStation.fillTheCar(new Car("Volvo s500")));
        executorService.execute(()->fuelStation.fillTheCar(new Car("Lada 2106")));
        executorService.execute(()->fuelStation.fillTheCar(new Car("Toyota Pr")));
        executorService.shutdown();

    }


}
