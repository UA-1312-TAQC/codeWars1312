package org.academy.utils;

import org.academy.kata.IEight;
import org.academy.kata.IFive;
import org.academy.kata.ISeven;
import org.academy.kata.ISix;

public enum Author {
    TANYAB777(1, "Bilka Tetiana", new org.academy.kata.implementation.TanyaB777.Eight(), new org.academy.kata.implementation.TanyaB777.Seven(), new org.academy.kata.implementation.TanyaB777.Six(), new org.academy.kata.implementation.TanyaB777.Five()),
    Dorrothee(2, "Boruk Daryna", new org.academy.kata.implementation.Dorrothee.Eight(), new org.academy.kata.implementation.Dorrothee.Seven(), new org.academy.kata.implementation.Dorrothee.Six(), new org.academy.kata.implementation.Dorrothee.Five());

    private final int id;
    private final String name;
    private final IEight eight;
    private final ISeven seven;
    private final ISix six;
    private final IFive five;

    Author(int id, String name, IEight eight, ISeven seven, ISix six, IFive five) {
        this.id = id;
        this.name = name;
        this.eight = eight;
        this.seven = seven;
        this.six = six;
        this.five = five;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IEight getEight() {
        return eight;
    }

    public ISeven getSeven() {
        return seven;
    }

    public ISix getSix() {
        return six;
    }

    public IFive getFive() {
        return five;
    }

    public static Author getAuthorById(int id){
        for(Author author : values()) {
            if (author.id == id){
                return author;
            }
        }
        return null;
    }

    public static void printAuthors() {
        for(Author author :values()) {
            System.out.println(author);
        }

    }


//    @Override
    public String toString() {
        return id + " " + name ;
    }
}
