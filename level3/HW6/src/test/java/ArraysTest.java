import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArraysTest {

//pull
    @Test
    void shouldReturnAnArrayAfterTheLast4(){
        Assertions.assertArrayEquals(new int[]{6,5},myMethodsArrays.cutOffAfterLast4(new int[]{4,6,5}));
        Assertions.assertArrayEquals(new int[]{3,5,3,6},myMethodsArrays.cutOffAfterLast4(new int[]{1,2,4,3,5,3,6}));
        Assertions.assertArrayEquals(new int[]{6},myMethodsArrays.cutOffAfterLast4(new int[]{1,2,3,3,4,6}));

    }
    @Test
    void shouldReturnAnExceptionNo4(){
        Assertions.assertThrows(RuntimeException.class,
                ()->myMethodsArrays.cutOffAfterLast4(new int[]{3,6,5}));
    }

    @Test
    void shouldReturnTrueSearch1or4(){
        Assertions.assertEquals(true,myMethodsArrays.search1or4(new int[]{3,5,4,1}));
    }

    @Test
    void shouldReturnFalseSearch1or4(){
        Assertions.assertEquals(false,myMethodsArrays.search1or4(new int[]{3,5}));
    }

    @Test
    void shouldReturnAnExceptionArrayNull(){
        Assertions.assertThrows(RuntimeException.class,
                ()->myMethodsArrays.search1or4(new int[]{}));
    }

}
