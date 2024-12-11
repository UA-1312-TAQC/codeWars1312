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

}
