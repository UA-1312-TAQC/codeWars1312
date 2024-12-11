package org.academy.utils;

import java.util.Arrays;

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

    public void getVolumeOfCuboid() {
        System.out.println("input double length");
        double length = reader.readDouble();
        System.out.println("input double width");
        double width = reader.readDouble();
        System.out.println("input double height");
        double height = reader.readDouble();
        double result = author.getEight().getVolumeOfCuboid(length, width, height);
        System.out.println("Volume of a cuboid: %.2f%n" + result);
    }

    public void runAmIWilson() {
        System.out.println("input prime number");
        int number = (int)reader.readLong();
        boolean result = author.getEight().am_i_wilson(number);
        System.out.println("number " + number + (result?" is wilson prime" : " is not wilson prime"));
    }

    public void Rainfall() {
        System.out.println("Input town name:");
        String town = reader.readString();

        System.out.println("Input rainfall data:");
        String data = reader.readString();

        double meanResult = author.getSix().mean(town, data);
        double varianceResult = author.getSix().variance(town, data);

        System.out.println("For the town " + town + ":");
        System.out.println("Mean rainfall: " + meanResult);
        System.out.println("Variance of rainfall: " + varianceResult);
    }

    public void Converter() {
        System.out.println("Enter miles per imperial gallon (mpg) to convert into kilometers per liter (kpl):");
        float mpg = reader.readFloat();
        float result = author.getEight().mpgToKPM(mpg);
        System.out.println("Kilometers per liter (kpl): " + result);
    };

    public void runDivisibleBy(){
        System.out.println("Enter integer numbers, separated by spaces:");
        int[] numbers = reader.readIntArr();

        System.out.println("Enter the divider:");
        int divider = reader.readInt();

        int[] result = author.getEight().divisibleBy(numbers, divider);

        System.out.println("Numbers divisible by " + divider + ": " + Arrays.toString(result));
    }
}
