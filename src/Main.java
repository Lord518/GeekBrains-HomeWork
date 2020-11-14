public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(100);
        Cat[] cats = {
                new Cat("Barsik", 15),
                new Cat("Hippo", 9),
                new Cat("Boris", 70),
                new Cat("Matroskin", 25)
        };
        plate.info();
        plate.addingFood(5);
        plate.info();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            cats[i].info();
            plate.info();

        }

    }

}
