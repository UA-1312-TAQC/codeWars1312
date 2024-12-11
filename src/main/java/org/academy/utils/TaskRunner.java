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

    public void getVolumeOfCuboid() {
        System.out.println("Input double length:");
        double length = reader.readDouble();
        System.out.println("Input double width:");
        double width = reader.readDouble();
        System.out.println("Input double height:");
        double height = reader.readDouble();
        double result = author.getEight().getVolumeOfCuboid(length, width, height);
        System.out.println("Volume of a cuboid: %.2f%n" + result);
    }

    public void stringToNumber() {
        System.out.println("Input string of numbers: ");
        String str = reader.readString();
        int result = author.getEight().stringToNumber(str);
        System.out.println("Converted string to number: " + result);
    }

    public void runAmIWilson() {
        System.out.println("input prime number");
        int number = (int) reader.readLong();
        boolean result = author.getEight().am_i_wilson(number);
        System.out.println("number " + number + (result ? " is wilson prime" : " is not wilson prime"));
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
    }

    ;

    public void SquareRoot() {
        System.out.println("Enter integers separated by spaces:");
        int[] array = reader.readIntArr();
        int[] resultArray = author.getEight().squareOrSquareRoot(array);
        System.out.println("Result array:");
        for (int el : resultArray) {
            System.out.print(el + " ");
        }
    }

    public void findTheSmallest() {
        System.out.print("Plese enter the long number: ");
        long num = reader.readLong();
        String numStr = Long.toString(num);
        long[] result = author.getFive().smallest(num);
        System.out.println("The smallest number created is: " + result[0]);
        System.out.println("We takes the: " + numStr.charAt((int)result[0]));
        System.out.println("And put it to the index: " + result[2]);
    }


    public void nba() {
        System.out.println("Input result sheet:");
        String resultSheet = reader.readString();

        System.out.println("Input team name:");
        String teamName = reader.readString();

        String result = author.getSix().nbaCup(resultSheet, teamName);
        System.out.println(result);
    }

}
