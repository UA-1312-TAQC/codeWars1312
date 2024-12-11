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
                System.out.println("Input should be an integer.");
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
                return reader.readLine().trim();
            } catch (IOException e) {
                System.out.println("Error reading input.");
            }
        }
    }

    public float readFloat() {
        while (true) {
            try {
                return Float.parseFloat(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be a float.");
            }
        }
    }

    public BigInteger readBigInteger() {
        while (true) {
            try {
                return new BigInteger(reader.readLine().trim());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be a BigInteger.");
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
                System.out.println("Input should be a space-separated list of integers.");
            }
        }
    }

    public String[] readStringArr() {
        while (true) {
            try {
                String[] arr = reader.readLine().trim().split("\\s+");
                return arr;
            } catch (IOException e) {
                System.out.println("Input should be a space-separated list of strings.");
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
                System.out.println("Input should be a space-separated list of doubles.");
            }
        }
    }

    public float[] readFloatArr() {
        while (true) {
            try {
                String[] in = reader.readLine().trim().split("\\s+");
                float[] arr = new float[in.length];
                for (int i = 0; i < in.length; i++) {
                    arr[i] = Float.parseFloat(in[i]);
                }
                return arr;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be a space-separated list of floats.");
            }
        }
    }

    public long[] readLongArr() {
        while (true) {
            try {
                String[] in = reader.readLine().trim().split("\\s+");
                long[] arr = new long[in.length];
                for (int i = 0; i < in.length; i++) {
                    arr[i] = Long.parseLong(in[i]);
                }
                return arr;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Input should be a space-separated list of longs.");
            }
        }
    }
}
