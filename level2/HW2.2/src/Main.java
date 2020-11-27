import com.sun.org.apache.xpath.internal.operations.Number;

public class Main {


    public static void main(String[] args) {
        // write your code here
        String[][] a = new String[][]{
                {"1", "1", "1", "1"},
                {"5", "1", "1", "1"},
                {"1", "1", "1", "1"},
                {"1", "1", "1", "1"}
        };
        squareArray(a);


    }

    public static void squareArray(String[][] a) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        if (a.length > 4) {
            throw new MyArraySizeException("array must be [4][4]");
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i].length != 4) {
                    throw new MyArraySizeException("array must be [4][4]");
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(a[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("not supported data in a cell x:" + i + " y:" + j, e);
                }
            }

        }
        System.out.println(sum);
    }
}
