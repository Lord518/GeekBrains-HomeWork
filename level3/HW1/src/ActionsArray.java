import java.util.ArrayList;
import java.util.Arrays;

public class ActionsArray {
   public static <T> void replacementCell(T array[],int a,int b){

   T buff = array[a];
   array[a]= array[b];
   array [b] = buff;

    }

    public static <T> ArrayList<T> converterToArrayList(T array[]){
       ArrayList<T> list = new ArrayList<>(Arrays.asList(array)) ;
      System.out.println(list.toString());
       return list;
    }

   public static <T> void print(T [] arr) {
      for (T a : arr){
         System.out.print(a+" ");
      }
   }
}
