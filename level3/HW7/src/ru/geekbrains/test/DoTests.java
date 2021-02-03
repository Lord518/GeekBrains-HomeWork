package ru.geekbrains.test;
//pull

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DoTests {
    private DoTests() {
    }

    public static void start(Class testClass) {
        System.out.println(testClass.getSimpleName());

        List<Method> beforeSuiteMethods = findMethodWithAnnotation(testClass, BeforeSuite.class);
        if (!beforeSuiteMethods.isEmpty() && beforeSuiteMethods.size() > 1) {
            throw new RuntimeException("BeforeSuite annotation must be only once");
        }

        List<Method> afterSuiteMethod = findMethodWithAnnotation(testClass, AfterSuite.class);

        if (!afterSuiteMethod.isEmpty() && afterSuiteMethod.size() > 1) {
            throw new RuntimeException("AfterSuite annotation must be only once");
        }

        if (!beforeSuiteMethods.isEmpty()) invokeMethod(testClass, beforeSuiteMethods.get(0));

        for (Method method : findMethodWithAnnotation(testClass, Test.class)) {
            invokeMethod(testClass, method);
        }


        if (!afterSuiteMethod.isEmpty()) invokeMethod(testClass, afterSuiteMethod.get(0));


    }

    private static void invokeMethod(Class testClass, Method method) {
        Object obj = initObject(testClass);
        try {
            method.setAccessible(true);
            method.invoke(obj);
            method.setAccessible(false);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static List<Method> findMethodWithAnnotation(Class tClass, Class<? extends Annotation> annotation) {

        List<Method> methods = new ArrayList<>();

        for (Method method : tClass.getDeclaredMethods()) {

            if (method.isAnnotationPresent(annotation)) {
                methods.add(method);
            }
        }

        if (annotation.equals(Test.class)) {
            methods.sort(new Comparator<Method>() {
                @Override
                public int compare(Method o1, Method o2) {
                    return o1.getAnnotation(Test.class).value() - o2.getAnnotation(Test.class).value();
                }
            });

        }

        return methods;
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
