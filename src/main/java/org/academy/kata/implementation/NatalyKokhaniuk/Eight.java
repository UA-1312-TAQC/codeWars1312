package org.academy.kata.implementation.NatalyKokhaniuk;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
   public int liters(double time)  {
        if(time<0) return -1;
        int litres=(int) (time/2);
        System.out.println("time = " + time + " ----> litres = " + litres);
        return litres;
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return 0;
    }

    @Override
    public float mpgToKPM(float mpg) {
        return 0;
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
        return new int[0];
    }

    @Override
    public int[] countPositivesSumNegatives(int[] input) {
        return new int[0];
    }

    @Override
    public int stringToNumber(String str) {
        return 0;
    }

    @Override
    public double TwoDecimalPlaces(double number) {
        double res=0.00;
        res=Math.round(number*100.00)/100.00;
        System.out.println(number+" is rounded "+res);
        return res;
    }

    @Override
    public int[] divisibleBy(int[] numbers, int divider) {
        if (numbers == null || numbers.length == 0) {
                return new int[] {};
        }
        int count=0;
        String resStr="\n[";
        for (int i = 0; i < numbers.length; i++) {
            resStr+=numbers[i];
            if(i != numbers.length-1)resStr+=", ";
            if(numbers[i]%divider==0)count++;
        }
        resStr+="], "+divider+" --> [";
        int[] res=new int[count];
        int x=0;
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i]%divider==0){
                resStr+=numbers[i];
                if(x != count-1)resStr+=", ";
                res[x]=numbers[i];
                x++;
            }
        }
        resStr+="].\n";
        System.out.print(resStr);
        return res;
    }
    private static boolean isPrime(long n) {
            if (n <= 1) {
                return false;
            }
            for (long i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        private static long factorialMod(long n, long mod) {
            long result = 1;
            for (long i = 1; i <= n; i++) {
                result = (result * i) % mod;
            }
            return result;
        }
    @Override
    public boolean am_i_wilson(long n) {
        if (!isPrime(n)) {
                System.out.println("\"" + n + "\" isn't a prime. Try another number.");
                return false;
            }
            long mod = n * n;
            long factorial = factorialMod(n - 1, mod);
            if ((factorial + 1) % mod == 0) {
                System.out.println("TRUE \"" + n + "\" is a Wilson prime.");
                return true;
            } else {
                System.out.println("FALSE \"" + n + "\" isn't a Wilson prime.");
                return false;
            }
    }
}
