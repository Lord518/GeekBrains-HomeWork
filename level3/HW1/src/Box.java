import java.util.ArrayList;

public class Box<T extends Fruit> {
    private String name;
    private ArrayList<T> fruit;

    public Box(String name) {
        this.fruit = new ArrayList<>();
       this.name = name;
    }

    public void addArrayList(T e) {
        fruit.add(e);
    }
    public float getWeight(){
        T e = fruit.get(0);

        return e.getWeight() * fruit.size();
    }

    public void setFruits(ArrayList<T> arr) {
        this.fruit = arr;
    }

    public ArrayList<T> getFruits() {
        return fruit;
    }

    public boolean compare(Box a) {
        float currentBox = getWeight();
        float otherBox = a.getWeight();
        return currentBox==otherBox;
    }

    public void moveTo(Box<T> other) {
        other.setFruits(getFruits());
         setFruits(new ArrayList<>());
    }

   public void print(){
        System.out.print(name+" ");
        for (T e : fruit){
        System.out.print(e.toString()+" ");
        }
        System.out.println();
    }

}
