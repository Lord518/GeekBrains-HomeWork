public class Dog extends Animals {
    Dog(String name){
        super(name);
    }

    public void run(int x) {
        if (x > 500) System.out.println(name +" run : false");
        if (x < 500) System.out.println(name +" run : true");
    }


    public void swim(int x) {
        if(x>10)System.out.println(name +" swim : false");
        if (x<10) System.out.println(name +" swim : true");

    }


    public void jump(float y) {
        if (y > 0.5) System.out.println(name +" jump : false");
        if (y < 0.5) System.out.println(name +" jump : true");
    }
}
