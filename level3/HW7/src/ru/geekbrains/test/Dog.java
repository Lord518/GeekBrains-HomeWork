package ru.geekbrains.test;

public class Dog {

    @BeforeSuite
    public void wakeUp() {
        System.out.println("Wake up " + this.getClass().getSimpleName());
    }

    @AfterSuite
    public void sleep() {
        System.out.println("Sleep " + this.getClass().getSimpleName());

    }

    @Test(value = 1)
    public void eat1() {
        System.out.println("eat1");
    }

    @Test(value = 2)
    public void eat2() {
        System.out.println("eat2");

    }

    @Test(value = 3)
    public void eat3() {
        System.out.println("eat3");

    }
}