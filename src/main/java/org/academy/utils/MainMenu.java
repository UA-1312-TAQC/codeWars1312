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
        System.out.println("1. Am I Wilson");
        System.out.println("2. Liters");
        System.out.println("3. Volume of cuboid");
        System.out.println("4. MPG to KPM");
        System.out.println("5. Square or square root");
        System.out.println("6. Count positives, sum negatives");
        System.out.println("7. String to number");
        System.out.println("8. Two decimal places");
        System.out.println("9. Divisible by");
        System.out.println("10. Gap");
        System.out.println("11. Zeros");
        System.out.println("12. Perimeter");
        System.out.println("13. Solve");
        System.out.println("14. Smallest");
        System.out.println("15. New average");
        System.out.println("16. Series sum");
        System.out.println("17. FindNb");
        System.out.println("18. Balance");
        System.out.println("19. Function f(x)");
        System.out.println("20. Mean");
        System.out.println("21. Variance");
        System.out.println("22. NBA Cup");
    }

    private void setAuthor() {
        Author.printAuthors();
        while (true) {
            System.out.println("Enter author's ID: ");
            int id = reader.readInt();
            if (id > 0 && id <= Author.values().length) {
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
            System.out.println("Enter task ID: ");
            int id = reader.readInt();
            switch (id) {
                case 1:
                    taskRunner.runAmIWilson();
                    break;
                case 2:
                    taskRunner.runLiters();
                    break;
                case 3:
                    taskRunner.runVolumeOfCuboid();
                    break;
                case 4:
                    taskRunner.runMpgToKpm();
                    break;
                case 5:
                    taskRunner.runSquareOrSquareRoot();
                    break;
                case 6:
                    taskRunner.runCountPositivesSumNegatives();
                    break;
                case 7:
                    taskRunner.runStringToNumber();
                    break;
                case 8:
                    taskRunner.runTwoDecimalPlaces();
                    break;
                case 9:
                    taskRunner.runDivisibleBy();
                    break;
                case 10:
                    taskRunner.runGap();
                    break;
                case 11:
                    taskRunner.runZeros();
                    break;
                case 12:
                    taskRunner.runPerimeter();
                    break;
                case 13:
                    taskRunner.runSolve();
                    break;
                case 14:
                    taskRunner.runSmallest();
                    break;
                case 15:
                    taskRunner.runNewAvg();
                    break;
                case 16:
                    taskRunner.runSeriesSum();
                    break;
                case 17:
                    taskRunner.runFindNb();
                    break;
                case 18:
                    taskRunner.runBalance();
                    break;
                case 19:
                    taskRunner.runFunctionF();
                    break;
                case 20:
                    taskRunner.runMean();
                    break;
                case 21:
                    taskRunner.runVariance();
                    break;
                case 22:
                    taskRunner.runNbACup();
                    break;
                default:
                    System.out.println("Incorrect task ID.");
                    break;
            }
            System.out.println("Do you want to run another task? (y/n): ");
            String answer = reader.readString();
            if (!answer.equalsIgnoreCase("y")) {
                isRun = false;
            }
        }
    }

    public void run() {
        boolean isRun = true;
        while (isRun) {
            printActions();
            System.out.println("Enter action ID: ");
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
                default:
                    System.out.println("Invalid action ID.");
            }
        }
    }
}
