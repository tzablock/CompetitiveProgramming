package com.exercises.recru;

public class GCTests {
    public static void main(String[] args) {
        Person p = new Person("Michasz");
        p = null;

        Person p1 = new Person("a");
        Person p2 = new Person("b");

        p1 = p2;

        methodCreteObject();

        new Person("noVar");

        System.gc();
    }
    private static void methodCreteObject(){
        Person p = new Person("ddfdf");
    }
}
class Person{
    private String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(name);
    }
}
