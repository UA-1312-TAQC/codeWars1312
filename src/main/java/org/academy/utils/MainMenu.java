package org.academy.utils;

public class MainMenu {
    private final ConsoleReader reader;
    private Author author;
    private TaskRunner taskRunner;


    public MainMenu() {
        this.reader = new ConsoleReader();
    }

    public void printActions(){
        System.out.println("1. show Authors");
        System.out.println("2. set Author");
        System.out.println("3. show tasks");
        System.out.println("4. run task");
        System.out.println("0. exit");
    }

    public void printTasks(){
        System.out.println("1. task1");
        System.out.println("2. task2");
        System.out.println("3. task3");
        System.out.println("4. task4");

    }

    private void setAuthor(){
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

    private void runTask(){

        boolean isRun = true;
        while (isRun) {
            printTasks();
            System.out.println("enter task id: ");
            int id = reader.readInt();
            switch (id){
                case 1:
                    taskRunner.runAmIWilson();
                    isRun = false;
                    break;
                default:
                    System.out.println("incorrect task id");
            }

        }
    }

    public void run(){
        boolean isRun = true;
        while (isRun) {
            printActions();
            System.out.println("enter actions id: ");
            int id = reader.readInt();
            switch (id){
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
