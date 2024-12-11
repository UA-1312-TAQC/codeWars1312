package org.academy;

import org.academy.utils.Author;
import org.academy.utils.ConsoleReader;
import org.academy.utils.MainMenu;
import org.academy.utils.TaskRunner;

public class App {
    public static void main(String[] args) {
//        System.out.println("Welcome on board!");
//        Author.printAuthors();
//        ConsoleReader reader = new ConsoleReader();
//        long n = reader.readLong();
//        Author a = Author.getAuthorById((int)n);
//        System.out.println(a);
//
//        int[] ids = reader.readIntArr();
//        for(int i: ids){
//            Author a2 = Author.getAuthorById(i);
//            System.out.println(a2);
//        }



//        boolean isRun = true;
//        ConsoleReader reader = new ConsoleReader();
//        Author author;
//        while (isRun){
//
//            System.out.println("enter id user");
//            int command = (int) reader.readLong();
//            author = Author.getAuthorById(command);
//            if(author == null) break;
//            TaskRunner taskRunner = new TaskRunner(author);
//            taskRunner.runAmIWilson();
//        }

        MainMenu app = new MainMenu();
        app.run();

    }


}
