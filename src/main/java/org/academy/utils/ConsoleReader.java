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
        return "";
    }

    public float readFloat() {
        return 0;
    }

    public BigInteger readBigInteger() {
        return BigInteger.ZERO;
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
        return new String[]{};
    }

    public double[] readDoubleArr() {
        return new double[]{};
    }


}
