package org.academy.utils;

public class MainMenu {
    private final ConsoleReader reader;
    private Author author;
    private TaskRunner taskRunner;


    public MainMenu() {
        this.reader = new ConsoleReader();
    }

    public void printActions() {
        System.out.println("1. show Authors");
        System.out.println("2. set Author");
        System.out.println("3. show tasks");
        System.out.println("4. run task");
        System.out.println("0. exit");
    }

    public void printTasks() {
        System.out.println("1. Keep Hydrated");
        System.out.println("2. Volume of a Cuboid");
        System.out.println("3. Miles per gallon to kilometers per liter");
        System.out.println("4. To square(root) or not to square(root)");
        System.out.println("5. Count of positives / sum of negatives");
        System.out.println("6. Convert a String to a Number");
        System.out.println("7. Formatting decimal places");
        System.out.println("8. Find numbers which are divisible by given number");
        System.out.println("9. Wilson primes");
        System.out.println("10. Looking for a benefactor");
        System.out.println("11. Sum of the first nth term of Series");
        System.out.println("12. Build a pile of Cubes");
        System.out.println("13. Easy Balance Checking");
        System.out.println("14. Floating-point Approximation (I)");
        System.out.println("15. Rainfall");
        System.out.println("16. Ranking NBA teams");
        System.out.println("17. Help the bookseller");
        System.out.println("18. Gap in Primes");
        System.out.println("19. Number of trailing zeros of N");
        System.out.println("20. Perimeter of squares in a rectangle");
        System.out.println("21. Which x for that sum?");
        System.out.println("22. Find the smallest");
    }

    private void setAuthor() {
        Author.printAuthors();
        while (true) {
            System.out.println("enter authors id: ");
            int id = reader.readInt();
            if (id > 0 && id < Author.values().length) {
                author = Author.getAuthorById(id);
                taskRunner = new TaskRunner(author);
                break;
            }
        }
    }

    private void runTask() {

        boolean isRun = true;
        while (isRun) {
            printTasks();
            System.out.println("enter task id: ");
            int id = reader.readInt();
            switch (id) {
                case 1:
                    taskRunner.runLiters();
                    isRun = false;
                    break;
                case 2:
                    taskRunner.runGetVolumeOfCuboid();
                    isRun = false;
                    break;
                case 3:
                    taskRunner.runMpgToKPM();
                    isRun = false;
                    break;
                case 4:
                    taskRunner.runSquareOrSquareRoot();
                    isRun = false;
                    break;
                case 5:
                    taskRunner.runCountPositivesSumNegatives();
                    isRun = false;
                    break;
                case 6:
                    taskRunner.runStringToNumber();
                    isRun = false;
                    break;
                case 7:
                    taskRunner.runAmIWilson();
                    isRun = false;
                    break;
                case 8:
                    taskRunner.runTwoDecimalPlaces();
                    isRun = false;
                    break;
                case 9:
                    taskRunner.runDivisibleBy();
                    isRun = false;
                    break;
                case 10:
                    taskRunner.runNewAvg();
                    isRun = false;
                    break;
                case 11:
                    taskRunner.runSeriesSum();
                    isRun = false;
                    break;
                case 12:
                    taskRunner.runFindNb();
                    isRun = false;
                    break;
                case 13:
                    taskRunner.runBalance();
                    isRun = false;
                    break;
                case 14:
                    taskRunner.runF();
                    isRun = false;
                    break;
                case 15:
                    taskRunner.runRainfall();
                    isRun = false;
                    break;
                case 16:
                    taskRunner.runNbaCup();
                    isRun = false;
                    break;
                case 17:
//                    taskRunner.runStockSummary();
                    isRun = false;
                    break;
                case 18:
                    taskRunner.runGap();
                    isRun = false;
                    break;
                case 19:
//                    taskRunner.runZeros();
                    isRun = false;
                    break;
                case 20:
//                    taskRunner.runPerimeter();
                    isRun = false;
                    break;
                case 21:
//                    taskRunner.runSolve();
                    isRun = false;
                    break;
                case 22:
                    taskRunner.runSmallest();
                    isRun = false;
                    break;
                default:
                    System.out.println("incorrect task id");
            }
        }
    }

    public void run() {
        boolean isRun = true;
        while (isRun) {
            printActions();
            System.out.println("enter actions id: ");
            int id = reader.readInt();
            switch (id) {
                case 0:
                    isRun = false;
                    break;
                case 1:
                    Author.printAuthors();
                    break;
                case 2:
                    setAuthor();
                    break;
                case 3:
                    printTasks();
                    break;
                case 4:
                    runTask();
                    break;
            }
        }
    }
}
