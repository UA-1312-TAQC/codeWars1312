package org.academy.utils;

import org.academy.kata.IEight;
import org.academy.kata.IFive;
import org.academy.kata.ISeven;
import org.academy.kata.ISix;

public enum Author {
    TANYA_B777(1, "Bilka Tetiana", new org.academy.kata.implementation.TanyaB777.Eight(), new org.academy.kata.implementation.TanyaB777.Seven(), new org.academy.kata.implementation.TanyaB777.Six(), new org.academy.kata.implementation.TanyaB777.Five()),
    DORROTHEE(2, "Boruk Daryna", new org.academy.kata.implementation.Dorrothee.Eight(), new org.academy.kata.implementation.Dorrothee.Seven(), new org.academy.kata.implementation.Dorrothee.Six(), new org.academy.kata.implementation.Dorrothee.Five()),
    NASTIA_DAMIAN(3, "Damian Anastasiia", new org.academy.kata.implementation.NastiaDamian.Eight(), new org.academy.kata.implementation.NastiaDamian.Seven(), new org.academy.kata.implementation.NastiaDamian.Six(), new org.academy.kata.implementation.NastiaDamian.Five()),
    ANASTASIIA_SUN(4, "Darmohrai Anastasiia", new org.academy.kata.implementation.AnastasiiaSun.Eight(), new org.academy.kata.implementation.AnastasiiaSun.Seven(), new org.academy.kata.implementation.AnastasiiaSun.Six(), new org.academy.kata.implementation.AnastasiiaSun.Five()),
    VOVANCHEK(5, "Kacherovskyi Volodymyr", new org.academy.kata.implementation.Vovanchek.Eight(), new org.academy.kata.implementation.Vovanchek.Seven(), new org.academy.kata.implementation.Vovanchek.Six(), new org.academy.kata.implementation.Vovanchek.Five()),
    KIYANOVSKAA(6, "Kiianovska Yuliia", new org.academy.kata.implementation.kiyanovskaa.Eight(), new org.academy.kata.implementation.kiyanovskaa.Seven(), new org.academy.kata.implementation.kiyanovskaa.Six(), new org.academy.kata.implementation.kiyanovskaa.Five()),
    NATALY_KOKHANIUK(7, "Kokhaniuk Nataliia", new org.academy.kata.implementation.NatalyKokhaniuk.Eight(), new org.academy.kata.implementation.NatalyKokhaniuk.Seven(), new org.academy.kata.implementation.NatalyKokhaniuk.Six(), new org.academy.kata.implementation.NatalyKokhaniuk.Five()),
    MISTER_V03(8, "Kravchenko Viktor", new org.academy.kata.implementation.MisterV03.Eight(), new org.academy.kata.implementation.MisterV03.Seven(), new org.academy.kata.implementation.MisterV03.Six(), new org.academy.kata.implementation.MisterV03.Five()),
    VAL_KUCH(9, "Kucherenko Valeriia", new org.academy.kata.implementation.ValKuch.Eight(), new org.academy.kata.implementation.ValKuch.Seven(), new org.academy.kata.implementation.ValKuch.Six(), new org.academy.kata.implementation.ValKuch.Five()),
    NESTEA4(10, "Panchoshna Anastasiia", new org.academy.kata.implementation.nestea4.Eight(), new org.academy.kata.implementation.nestea4.Seven(), new org.academy.kata.implementation.nestea4.Six(), new org.academy.kata.implementation.nestea4.Five()),
    IVAN_ROMANUIK2014(11, "Romaniuk Ivan", new org.academy.kata.implementation.ivanromanuik2014.Eight(), new org.academy.kata.implementation.ivanromanuik2014.Seven(), new org.academy.kata.implementation.ivanromanuik2014.Six(), new org.academy.kata.implementation.ivanromanuik2014.Five()),
    DANIIL_RUSANOV(12, "Rusanov Daniil", new org.academy.kata.implementation.daniilrusanov.Eight(), new org.academy.kata.implementation.daniilrusanov.Seven(), new org.academy.kata.implementation.daniilrusanov.Six(), new org.academy.kata.implementation.daniilrusanov.Five()),
    NIKER01(13, "Soltys Nikita", new org.academy.kata.implementation.niker01.Eight(), new org.academy.kata.implementation.niker01.Seven(), new org.academy.kata.implementation.niker01.Six(), new org.academy.kata.implementation.niker01.Five()),
    BASIL_JAWORSKI(14, "Yavorskyi Vasyl", new org.academy.kata.implementation.BasilJaworski.Eight(), new org.academy.kata.implementation.BasilJaworski.Seven(), new org.academy.kata.implementation.BasilJaworski.Six(), new org.academy.kata.implementation.BasilJaworski.Five());

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
