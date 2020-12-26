import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
         String [] arrays = new String[]{"1","2","3","4","5","6"};
         //1
        ActionsArray.replacementCell(arrays,0,1);
        ActionsArray.print(arrays);
         //2
        ActionsArray.converterToArrayList(arrays);
         //3
        Box <Apple> b1 = new Box<>("b1");
        Box <Orange> b2 = new Box<>("b2");
        b1.addArrayList(new Apple());
        b1.addArrayList(new Apple());
        System.out.println(b1.getWeight());
        b2.addArrayList(new Orange());
        b2.addArrayList(new Orange());
        b2.addArrayList(new Orange());
        b2.addArrayList(new Orange());
        System.out.println(b2.getWeight());
        System.out.println(b1.compare(b2));
        Box <Apple> b3 = new Box<>("b3");
        b3.addArrayList(new Apple());
        b1.print();
        b1.moveTo(b3);
        b1.print();
        b3.print();


    }
}
