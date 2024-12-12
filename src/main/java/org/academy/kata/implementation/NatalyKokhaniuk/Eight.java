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
        return 0;
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

    @Override
    public boolean am_i_wilson(long n) {
        return false;
    }
}
