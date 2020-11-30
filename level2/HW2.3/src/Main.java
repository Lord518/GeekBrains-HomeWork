import java.util.*;
//pull-request
public class Main {

    public static void main(String[] args) {
    //exercise 1
        List<String> fruit = new ArrayList<String>(
                Arrays.asList("apple", "banana", "kiwi",
                        "kiwi", "mango", "peach",
                        "pineapple", "kiwi", "kiwi",
                        "banana", "pineapple"));
        System.out.println(fruit);
        System.out.println(deleteCopy(fruit));
        System.out.println(sumCopy(fruit));
    //exercise 2
        PhoneBook p = new PhoneBook();
        p.addPerson("Volkov", 462563);
        p.getNumber("Volkov");
    }

    static List<String> deleteCopy(List<String> e) {
        List<String> arrayE = new ArrayList<>(e);
        List<String> deleteCopy = new ArrayList<>();

        for (int i = 0; i < arrayE.size(); i++)
        {
            String cell = arrayE.get(i);
            for (int j = 0; j < arrayE.size(); j++)
            {
                if (cell.equals(arrayE.get(j))) { arrayE.remove(j); }
            }
            deleteCopy.add(cell);
        }
        return deleteCopy;
    }

    static List<String> sumCopy(List<String> e) {
        List<String> arrayE = new ArrayList<>(e);
        List<String> deleteCopy = deleteCopy(e);
        List<String> arraySum = new ArrayList<String>();
        int sum;

        for (int i = 0; i < deleteCopy.size(); i++)
        {
            sum = 0;
            String cell = deleteCopy.get(i);
            for (int j = 0; j < arrayE.size(); j++)
            {

                if (cell.equals(arrayE.get(j))) { sum++; }

            }
            cell = deleteCopy.get(i) + " " + sum;
            arraySum.add(i, cell);
        }

        return arraySum;
    }

}