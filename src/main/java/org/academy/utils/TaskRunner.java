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

    public void runCountPositivesSumNegatives() {
        System.out.println("input array of integers");
        int[] numbers = reader.readIntArr();
        int[] result = author.getEight().countPositivesSumNegatives(numbers);
        if (result.length == 0) {
            System.out.println("Result: empty array");
        } else {
            System.out.println("Count of positives: " + result[0]);
            System.out.println("Sum of negatives: " + result[1]);
        }
    }

}
