package org.academy.utils;

public class TaskRunner {
    Author author;
    ConsoleReader reader;
    public TaskRunner(Author author) {
        this.author = author;
        this.reader = new ConsoleReader();
    }

    public void keepHydrated() {
        System.out.println("input double number");
        double hours = reader.readDouble();
        int result = author.getEight().liters(hours);
        System.out.println("In " + hours + " Nathan will drink " + result + " liters");
    }

    public void runAmIWilson() {
        System.out.println("input prime number");
        int number = (int)reader.readLong();
        boolean result = author.getEight().am_i_wilson(number);
        System.out.println("number " + number + (result?" is wilson prime" : " is not wilson prime"));
    }


}
