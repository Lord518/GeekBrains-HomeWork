public class Main {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Cat Fedor");
        cat1.run(250);
        cat1.run(250,500);
        cat1.swim();
        cat1.swim(1,2);
        cat1.jump(1);
        Dog dog1 = new Dog("Dog Boss");
        dog1.run(600);
        dog1.run(1000,2000);
        dog1.swim(7);
        dog1.swim(10,11);
        dog1.jump(0.3f);
        dog1.jump(0.5f,0.5f);
    }

}
