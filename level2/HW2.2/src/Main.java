public class Main {

    public static void main(String[] args) {
	// write your code here
String [][] a= new String[][] {
        {"1","1","1","1"},
        {"5","1","1","1"},
        {"1","1","1","1"},
        {"1","1","1","1"}
};

    try {
        try {
            aArray(a);
        }catch (MyArrayDataException e){
System.out.println("JKSDFJ");
        }

    } catch (MyArraySizeException e) {
        e.printStackTrace();
        System.out.println("Final");
    }




    }
    public static void aArray(String [][] a) throws MyArraySizeException,MyArrayDataException
     {

        if(a.length>4 || a[0].length> 4){
         throw new MyArraySizeException();
        }
         int sum=0;
        for(int i=0;i<a.length;i++)
        {
            for (int j=0;j<a[i].length;j++)
            {
                String cell = a[i][j];
               // if((Integer.parseInt(cell))!= Integer){

          //  }
                sum =sum + Integer.parseInt(cell);
            }
        }
        System.out.println(sum);
    }
}
