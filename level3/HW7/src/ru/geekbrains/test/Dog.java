package ru.geekbrains.test;

public class Dog {


    @BeforeSuite
    private void wakeUp1() { System.out.println("Wake up " + this.getClass().getSimpleName());
    }
    @AfterSuite
    private void sleep() {
        System.out.println("Sleep " + this.getClass().getSimpleName());

    }

    @Test(value = 3)
    private void eat1() {
        System.out.println("eat3");
    }

    @Test(value = 2)
    private void eat2() {
        System.out.println("eat2");

    }

    @Test(value = 1)
    private void eat3() {
        System.out.println("eat1");

    }
}