import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PhoneBook {

    private List<Person> p = new ArrayList<Person>(Arrays.asList(
            new Person("Smirnov", 405061),
            new Person("Popov", 405062),
            new Person("Fedorov", 405063),
            new Person("Elcin", 405064),
            new Person("Elcin", 405065),
            new Person("Ivanov", 405066),
            new Person("Petrov", 405067),
            new Person("Makarov", 405068),
            new Person("Volkov", 405069),
            new Person("Volkov", 405070),
            new Person("Volkov", 405071),
            new Person("Andreev", 405072)
    ));

    public void addPerson(String family, int phoneNumber)
    {
        p.add(new Person(family, phoneNumber));
    }

    public void getNumber(String f)
    {
        System.out.println("Looking for: " + f);
        for (int i = 0; i < p.size(); i++)
        {
            String s = p.get(i).getFamily();
            if (f.equals(s)) { System.out.println(p.get(i).toString()); }
        }
    }

    private class Person {
        private String family;
        private int phoneNumber;

        public Person(String family, int phoneNumber) {
            this.family = family;
            this.phoneNumber = phoneNumber;
        }

        public String getFamily() {
            return family;
        }

        @Override
        public String toString() {
            return "family='" + family + '\'' +
                    ", phoneNumber=" + phoneNumber;
        }
    }
}
