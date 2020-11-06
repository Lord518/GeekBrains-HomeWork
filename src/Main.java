public class Main {
    public static void main(String[] args) {
        Employee[] array = new Employee[5];
        array[0] = new Employee("Oleg Olegov", "director", "oleg.o@mail.ru", 405060, 50000, 45);
        array[1] = new Employee("Max Paine", "security guard", "max.p@mail.ru", 405061, 30000, 28);
        array[2] = new Employee("Kate Baker", "manager", "kate.b@mail.ru", 405062, 35000, 36);
        array[3] = new Employee("Anna Anisimova", "accountant", "anna.a@mail.ru", 405063, 45000, 43);
        array[4] = new Employee("Petr Torgovcev", "manager", "petr.t@mail.ru", 405064, 35000, 30);

        for (int i =0;i< array.length;i++)
        {
           if(array[i].getAge()>40) array[i].dataEmployee();
        }
    }

}
