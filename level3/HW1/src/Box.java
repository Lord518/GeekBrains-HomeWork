import java.util.ArrayList;
//pull-request
public class Box<T extends Fruit> {
    private String name;
    private ArrayList<T> fruits;

    public Box(String name) {
        this.fruits = new ArrayList<>();
        this.name = name;
    }

    public void addArrayList(T e) {
        fruits.add(e);
    }

    public float getWeight() {
        T e = fruits.get(0);

        return e.getWeight() * fruits.size();
    }

    public void setFruits(ArrayList<T> fruit) {
        this.fruits = fruit;
    }

    public ArrayList<T> getFruits() {
        return fruits;
    }

    public boolean compare(Box a) {
        float currentBox = getWeight();
        float otherBox = a.getWeight();
        return currentBox == otherBox;
    }

    public void moveTo(Box<T> b) {
        b.setFruits(getFruits());
        setFruits(new ArrayList<>());
    }

    public void print() {
        System.out.print(name + " ");
        for (T e : fruits) {
            System.out.print(e.toString() + " ");
        }
        System.out.println();
    }

}
