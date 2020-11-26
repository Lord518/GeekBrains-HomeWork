import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args)
    {
        char[][] field = createNewField();
        do {
            doPlayerMove(field);
            drawField(field);
            if (true == checkWin(field, 'X')) { break; }
            if(checkDraw(field)){ System.out.println("It is draw! Sorry!");break;}
            System.out.println();
            moveAI(field);
            drawField(field);
            if (true == checkWin(field, 'O')) { break; }
            if(checkDraw(field)){ System.out.println("It is draw! Sorry!");break;}
        }
        while (true);
    }

    public static void moveAI(char[][] field)
    {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(field.length);
            y = random.nextInt(field.length);
           }
        while (field[x][y] != '-');
        field[x][y] = 'O';
    }


    public static boolean checkWin(char[][] field, char sign)
    {
        //Horizontal
        for (int i = 0; i < field.length; i++)
        {
            int count = 0;
            for (int j = 0; j < field[i].length; j++)
            {
                if (field[i][j] == sign) { count++; }
                if (count == field.length)
                {
                    System.out.println(sign + " Win!!!");
                    return true;
                }
            }
        }
        //Vertical
        for (int i = 0; i < field.length; i++)
        {
            int count = 0;
            for (int j = 0; j < field[i].length; j++)
            {
                if (field[j][i] == sign) { count++; }
                if (count == field.length)
                {
                    System.out.println(sign + " Win!!!");
                    return true;
                }
            }
        }

        // Main diagonal
        for (int i = 0; i < field.length; i++)
        {
            int count = 0;
            for (int j = 0; j < field[i].length; j++)
            {
                if (field[j][j] == sign) { count++; }
                if (count == field.length)
                {
                    System.out.println(sign + " Win!!!");
                    return true;
                }
            }
        }
        //Second diagonal
        for (int i = 0; i < field.length; i++)
        {
            int count = 0;
            for (int j = 0; j < field[i].length; j++)
            {
                if (field[j][field.length - 1 - j] == sign) { count++; }
                if (count == field.length)
                {
                    System.out.println(sign + " Win!!!");
                    return true;
                }
            }
        }
        return false;
    }

    static void doPlayerMove(char[][] field)
    {
        int x, y;
        do {
            x = getCoordinate('X', field.length);
            y = getCoordinate('Y', field.length);
        } while (field[x][y] != '-');
        field[x][y] = 'X';
    }

    static int getCoordinate(char coordName, int max)
    {
        int coord;
        do {
            System.out.println(String.format("Please input %s-coordinate [1-%s]", coordName, max));
            Scanner scanner = new Scanner(System.in);
            coord = scanner.nextInt();
        } while (coord < 1 || coord > max);

        return coord - 1;
    }

    static boolean checkDraw(char[][] field)
    {
        int maxMinus = field.length * field.length;
        for (int i = 0; i < field.length; i++)
        {
            for (int j = 0; j < field[i].length; j++)
            {
                if (field[i][j] != '-') { maxMinus--; }
            }
        }
        return maxMinus == 0;
    }


    static void drawField(char[][] field)
    {
        for (int i = 0; i < field.length; i++)
        {
            for (int j = 0; j < field[i].length; j++)
            { System.out.print(field[i][j] + " "); }
            System.out.println();
        }
    }

    static char[][] createNewField()
    {
        return new char[][]{
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'},
                {'-', '-', '-', '-', '-'}
        };
    }
}
