public class Cat extends Animals {

Cat(String name){
    super(name);
}
    public void run(int x) {
        if (x > 200) System.out.println(name+ " run : false");
        if (x <= 200) System.out.println(name +" run : true");
    }

    public void swim() {
        System.out.println(name +" swim : false");
    }

    @Override
    public void swim(int x, int limited) {
        System.out.println(name + " swim : false");
    }

    public void jump(float y) {
        if (y > 2) System.out.println(name +" jump : false");
        if (y <= 2) System.out.println(name +" jump : true");
    }
}
