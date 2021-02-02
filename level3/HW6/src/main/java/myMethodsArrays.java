public class myMethodsArrays {

    static int[] cutOffAfterLast4(int[] values) {
        if (values == null || values.length == 0) { throw new RuntimeException("Array cannot be empty!"); }
        int index = -1;
         for (int i = 0; i < values.length; i++) {
                    if (values[i] == 4) {
                        index = i + 1;
                    }
                }
         if (index == -1) { throw new RuntimeException("There was no four found!"); }
                int[] copied = new int[values.length - index];
                System.arraycopy(values, index, copied, 0, copied.length);
                return copied;
    }





    static boolean search1or4(int[] arr) {
        if (arr == null || arr.length == 0) { throw new RuntimeException("Array cannot be empty!"); }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 || arr[i] == 4) {
                return true;
            }
        }
        return false;
    }

}
