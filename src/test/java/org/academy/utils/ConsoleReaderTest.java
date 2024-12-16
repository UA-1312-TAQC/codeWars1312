package org.academy.utils;

import com.sun.source.tree.AssertTree;
import org.academy.utils.dataprovider.LongDataProvider;
import org.academy.kata.dataprovider.UtilsDataProvider;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;

import org.academy.utils.dataprovider.LongDataProvider.*;

import static org.testng.Assert.*;

public class ConsoleReaderTest extends UtilsDataProvider{

    @Test
    public void testReadInt() {
    }

    @Test(dataProvider = "double-input")
    public void testReadDouble(String input, double expected) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);

        double actual = consoleReader.readDouble();
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test(dataProvider = "data-readString")
    public void testReadString(String input, String output) {

        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);
        String actual = consoleReader.readString();
        String expected = output;
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void testReadFloat() {
        // positive float
        String positiveFloatInput = "18.15\n";
        InputStream inputStream = new ByteArrayInputStream(positiveFloatInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);
        double actual = consoleReader.readFloat();
        double expected = 18.15;
        Assert.assertEquals(actual, expected, 0.0001);

        // negative float
        String negativeFloatInput = "-91.47\n";
        inputStream = new ByteArrayInputStream(negativeFloatInput.getBytes());
        consoleReader = new ConsoleReader(inputStream);
        actual = consoleReader.readFloat();
        expected = -91.47;
        Assert.assertEquals(actual, expected, 0.0001);

        // zero
        String zeroInput = "0.0\n";
        inputStream = new ByteArrayInputStream(zeroInput.getBytes());
        consoleReader = new ConsoleReader(inputStream);
        actual = consoleReader.readFloat();
        expected = 0.0;
        Assert.assertEquals(actual, expected, 0.0001);
    }

    @Test
    public void testReadBigInteger() {
        String positiveBigIntInput = "1234567890123456789012345678901234567890\n";
        InputStream inputStream = new ByteArrayInputStream(positiveBigIntInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);
        BigInteger actual = consoleReader.readBigInteger();
        BigInteger expected = new BigInteger("1234567890123456789012345678901234567890");
        Assert.assertEquals(actual, expected, "The BigInteger should match the input.");

        String negativeBigIntInput = "-1234567890123456789012345678901234567890\n";
        inputStream = new ByteArrayInputStream(negativeBigIntInput.getBytes());
        consoleReader = new ConsoleReader(inputStream);
        actual = consoleReader.readBigInteger();
        expected = new BigInteger("-1234567890123456789012345678901234567890");
        Assert.assertEquals(actual, expected, "The BigInteger should match the input.");

        String zeroBigIntInput = "0\n";
        inputStream = new ByteArrayInputStream(zeroBigIntInput.getBytes());
        consoleReader = new ConsoleReader(inputStream);
        actual = consoleReader.readBigInteger();
        expected = BigInteger.ZERO;
        Assert.assertEquals(actual, expected, "The BigInteger should be zero.");

        String invalidBigIntInput = "abc123\n";
        inputStream = new ByteArrayInputStream(invalidBigIntInput.getBytes());
        consoleReader = new ConsoleReader(inputStream);
        actual = consoleReader.readBigInteger();
        expected = BigInteger.ZERO;
        Assert.assertEquals(actual, expected, "The BigInteger should be zero when input is invalid.");
    }

    @Test(dataProviderClass = LongDataProvider.class, dataProvider = "validGreaterThanZero")
    public void testReadLong001(String data) {
        uniLongInputTest(data);
    }

    @Test(dataProviderClass = LongDataProvider.class, dataProvider = "validLessThenZero")
    public void testReadLong002(String data) {
        uniLongInputTest(data);
    }

    @Test(dataProviderClass = LongDataProvider.class, dataProvider = "validBoundaryValues")
    public void testReadLong003(String data) {
        uniLongInputTest(data);
    }

    @Test(dataProviderClass = LongDataProvider.class, dataProvider = "invalidSymbols")
    public void testReadLong004(String data) {
        uniNotLongInputTest(data);
    }

    @Test(dataProviderClass = LongDataProvider.class, dataProvider = "invalidGreaterThanMAX")
    public void testReadLong005(String data) {
        uniNotLongInputTest(data);
    }

    @Test(dataProviderClass = LongDataProvider.class, dataProvider = "invalidLessThanMIX")
    public void testReadLong006(String data) {
        uniNotLongInputTest(data);
    }

    @Test(dataProviderClass = LongDataProvider.class, dataProvider = "invalidLikeDouble")
    public void testReadLong007(String data) {
        uniNotLongInputTest(data);
    }

    private void uniLongInputTest(String data) {
        String newData = data + "\n777\n";
        InputStream inputStream = new ByteArrayInputStream(newData.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);
        long actual = consoleReader.readLong();
        Assert.assertEquals(actual, Long.parseLong(data));
    }

    private void uniNotLongInputTest(String data) {
        String newData = data + "\n777\n";
        ByteArrayInputStream input = new ByteArrayInputStream(newData.getBytes());
        System.setIn(input);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        ConsoleReader consoleReader = new ConsoleReader();
        consoleReader.readLong();

        String consoleOutput = output.toString();
        Assert.assertTrue(consoleOutput.contains("Input should be a long."));
    }

    @Test
    public void testReadIntArr() {
        // positive
        String simulatedInput = "10 20 30 40 50\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);

        int[] actual = consoleReader.readIntArr();
        int[] expected = { 10, 20, 30, 40, 50 };

        assertTrue(Arrays.equals(actual, expected));

        // negative
        simulatedInput = "\naa b c\n0.8 7.9\n10 20 30 40 50\n";
        inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        consoleReader = new ConsoleReader(inputStream);

        actual = consoleReader.readIntArr();
        assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void testReadStringArr() {
        String[] expectedStringArr = new String[] { "Automation", "Testing", "in", "Java" };

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

        // Validate that the result contains a single empty string
        assertEquals(resultEmptyInput.length, 1); // Expect one element
        assertEquals(resultEmptyInput[0], ""); // Validate that the element is an empty string

    }

    @Test
    public void testReadStringArrByComma() {
        String simulatedInput = "one,two,three";

        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);

        String[] actual = consoleReader.readStringArrByComma();
        String[] expected = { "one", "two", "three" };

        assertEquals(actual, expected);
    }

    @Test
    public void testReadDoubleArrValidInput() {
        String simulatedInput = "1.2 3.4 5.6\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);

        double[] result = consoleReader.readDoubleArr();
        Assert.assertEquals(result, new double[] { 1.2, 3.4, 5.6 }, "The array should match the input values.");
    }

    @Test
    public void testReadDoubleArrEmptyAndValidInput() {
        String simulatedInput = " \n1.2 3.4 5.6\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);

        double[] result = consoleReader.readDoubleArr();
        Assert.assertEquals(result, new double[] { 1.2, 3.4, 5.6 },
                "The method should skip empty lines and return valid input.");
    }

    @Test
    public void testReadDoubleArrInvalidAndValidInput() {
        String simulatedInput = "abc\n1.2 3.4 5.6\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        ConsoleReader consoleReader = new ConsoleReader(inputStream);

        double[] result = consoleReader.readDoubleArr();
        Assert.assertEquals(result, new double[] { 1.2, 3.4, 5.6 },
                "The method should handle invalid input and return valid input.");
    }

    @Test
    public void testReadMultipleLines() {
        Object[][] testCases = {
                { "Hello\nThis is a test\nDONE\n", "Hello\nThis is a test" },
                { "Line 1\nLine 2\nLine 3\nDONE\n", "Line 1\nLine 2\nLine 3" },
                { "Only one line\nDONE\n", "Only one line" },
                { "First Line\nSecond Line\nThird Line\nDONE\n", "First Line\nSecond Line\nThird Line" },
                { "Empty input followed by DONE\nDONE\n", "Empty input followed by DONE" },

        };

        for (Object[] testCase : testCases) {
            String input = (String) testCase[0];
            String expectedOutput = (String) testCase[1];

            InputStream testInput = new ByteArrayInputStream(input.getBytes());
            ConsoleReader consoleReader = new ConsoleReader(testInput);

            String actualOutput = consoleReader.readMultipleLines("DONE");

            assertEquals(actualOutput, expectedOutput, "Input does not match expected output for input: " + input);
        }
    }
}
