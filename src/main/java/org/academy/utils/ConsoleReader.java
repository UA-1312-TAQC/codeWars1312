package org.academy.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConsoleReader {

    public BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readInt() {
        while (true) {
            try {
                return Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be a long.");
            }
        }
    }

    public double readDouble() {
        while (true) {
            try {
                return Double.parseDouble(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be a double.");
            }
        }
    }

    public String readString() {
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                System.out.println("Input should be a string in one line.");
            }
            
        }
    }

    public float readFloat() {
        while (true) {
            try {
                System.out.print("Enter a float value: ");
                return Float.parseFloat(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid float value.");
            }
        }
    }

    public BigInteger readBigInteger() {
        while (true) {
            try {
                System.out.print("Enter a BigInteger value: ");
                return new BigInteger(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid BigInteger value.");
            }
        }
    }

    public long readLong() {
        while (true) {
            try {
                return Long.parseLong(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be a long.");
            }
        }
    }

    public int[] readIntArr() {
        while (true) {
            try {
                String[] in = reader.readLine().trim().split("\\s+");
                int[] arr = new int[in.length];
                for (int i = 0; i < in.length; i++) {
                    arr[i] = Integer.parseInt(in[i]);
                }

                return arr;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be a long.");
            }
        }
    }

    public String[] readStringArr() {
        while (true) {
            try {
                String[] arr = reader.readLine().trim().split(",\\s*");
                if (arr.length == 0) {
                    System.out.println("The input cannot be empty. Please try again.");
                    continue;
                }
                return arr;
            } catch (IOException e) {
                System.out.println("The input string value should be separated by a comma and a space.");
            }
        }
    }

    public double[] readDoubleArr() {
        while (true) {
            try {
                String[] in = reader.readLine().trim().split("\\s+");
                double[] arr = new double[in.length];
                for (int i = 0; i < in.length; i++) {
                    arr[i] = Double.parseDouble(in[i]);
                }
                return arr;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be doubles separated by spaces.");
            }
        }
    }

}
