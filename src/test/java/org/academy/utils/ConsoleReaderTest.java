package org.academy.utils;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
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
    }

    @Test
    public void testReadStringArrByComma() {
    }

    @Test
    public void testReadDoubleArr() {
    }

    @Test
    public void testReadMultipleLines() {
    }
}