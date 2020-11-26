public abstract class Animals {
String name;

    public Animals(String name) {
        this.name = name;
    }

    public void run(int x, int limited) {
        if (x > limited ) System.out.println(name +" run : false");

        if (x <= limited) System.out.println(name +" run : true");

    }

    public void swim(int x, int limited) {
        if (x > limited) System.out.println(name + " swim : false");

        if (x <= limited) System.out.println(name +" swim : true");

    }

    public void jump(float y, float limited) {
        if (y > limited ) System.out.println(name +" jump : false");

        if (y <= limited) System.out.println(name +" jump : true");

    }
}
