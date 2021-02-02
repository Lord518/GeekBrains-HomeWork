package ru.geekbrains.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoTests {


    public static void start(Class testClass) throws Exception {
        Object dog = initObject(testClass);
        System.out.println(testClass.getSimpleName());
        List<Method> methods = Arrays.asList(testClass.getDeclaredMethods());
        //   Method[] methods1 = testClass.getDeclaredMethods();
            List<Method> methods1 = sort(methods);

        for (int i = 0; i < methods.size(); i++) {
            System.out.println(methods1.get(i).invoke(dog));
            //if(methods.get(i).isAnnotationPresent(Test.class)){
            //Test test = methods.get(i).getAnnotation(Test.class);
            //System.out.println(test);}
    }}

    private static List<Method> sort(List<Method> methods)
    { List<Method> sortMethods= new ArrayList<>(methods.size());
       for(int i = 0;i<methods.size();i++){
        if(methods.get(i).isAnnotationPresent(BeforeSuite.class)){sortMethods.set(0,methods.get(i));}
        if(methods.get(i).isAnnotationPresent(Test.class)){
            for(int j =1;j<=10;j++) {
         Test test = methods.get(i).getAnnotation(Test.class);

           if(test.value()==j){

               sortMethods.set(j,methods.get(i));
           }
            }
            if(methods.get(i).isAnnotationPresent(AfterSuite.class)){sortMethods.set(methods.size()-1,methods.get(i));}



//sortMethods.set(0, methods.get(j));
            }
        }




        return sortMethods;
    }



    private static Object initObject(Class testClass) {
        try {
            return testClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException
                | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("SWW", e);
        }
    }
}
