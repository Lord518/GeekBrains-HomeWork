import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
  /*  public static void main(String[] args) {


        startGame();

    }*/

    public static void restartGame() {
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int i = scan();
        if (i == 1) {
            startGame();
        }
        if (i == 0) {
            System.out.println("Конец игры!!!");
        }

    }

    public static int scan() {
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        return s;
    }

    public static int randomNumbers() {
        Random random = new Random();
        return random.nextInt(10);
    }
    public static boolean comparison(int s, int r) {
        if (s == r) {
            return true;
        } else if (s > r) {
            System.out.println("Загаданное число меньше");
            return false;
        }
        System.out.println("Загаданное число больше");
        return false;
    }


    public static void startGame() {
        int r = randomNumbers();
        System.out.println("У вас три попытки отгадать число  от 0 до 9");
        for (int i = 0; i < 3; i++) {

            boolean n = comparison(scan(), r);
            if (n == true) {
                System.out.println("Вы победили!!!");
                restartGame(); break;}
             if (n==false&&i==2){
                 System.out.println("Вы проиграли!!! Загаданное число "+r);
                 restartGame();break;
             }
            }
        }
    }







