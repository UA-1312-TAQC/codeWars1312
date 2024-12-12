package org.academy.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Arrays;

import static org.testng.Assert.*;

public class ConsoleReaderTest {

    @Test
    public void testReadInt() {
    }

    @Test
    public void testReadDouble() {
    }

    @Test
    public void testReadString() {
    }

    @Test
    public void testReadFloat() {
    }

    @Test
    public void testReadBigInteger() {
    }

    @Test
    public void testReadLong() {
    }

    @Test
    public void testReadIntArr() {
        String simulatedInput = "10 20 30 40 50\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);

        int[] actual = consoleReader.readIntArr();
        int[] expected = {10, 20, 30, 40, 50};

        assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void testReadStringArr() {
        String[] expectedStringArr = new String[]{"Automation", "Testing", "in", "Java"};

        // --Valid data--
        String validInput = "Automation, Testing, in, Java\n";
        InputStream inputStream = new ByteArrayInputStream(validInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);
        String[] resultValidInput = consoleReader.readStringArr();
        assertTrue(Arrays.equals(expectedStringArr, resultValidInput));

        // --Empty input--
        String emptyInput = "\n"; // Single empty line only
        inputStream = new ByteArrayInputStream(emptyInput.getBytes());
        consoleReader = new ConsoleReader(inputStream);
        String[] resultEmptyInput = consoleReader.readStringArr();

        //Validate that the result contains a single empty string
        assertEquals(resultEmptyInput.length, 1); //Expect one element
        assertEquals(resultEmptyInput[0], ""); //Validate that the element is an empty string

    }

    @Test
    public void testReadStringArrByComma() {
        String simulatedInput = "one,two,three";

        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);

        String[] actual = consoleReader.readStringArrByComma();
        String[] expected = {"one", "two", "three"};

        assertEquals(actual, expected);
    }

    @Test
    public void testReadDoubleArr() {
    }

    @Test
    public void testReadMultipleLines() {
    }
}