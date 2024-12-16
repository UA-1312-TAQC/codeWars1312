package org.academy.kata.dataprovider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

public class UtilsDataProvider {

    @DataProvider(name = "data-readString")
    public static Iterator<String[]> dpReadString() {
        final List<String> input = new ArrayList<>();
        input.add("\s\s");
        input.add("\t");
        input.add("12345");
        input.add("I am Betman");
        input.add("!?/#::#L:\'");

        final List<String> output = new ArrayList<>();
        output.add("\s\s");
        output.add("\t");
        output.add("12345");
        output.add("I am Betman");
        output.add("!?/#::#L:\'");

        final List<String[]> pairs = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            pairs.add(new String[]{input.get(i), output.get(i)});
        }

        return pairs.iterator();

    }

}
