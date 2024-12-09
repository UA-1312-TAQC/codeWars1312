package org.academy.kata.implementation.Vovanchek;


import org.academy.kata.IEight;

public class Eight implements IEight {
    @Override
    public int liters(double time) {
        return (int)Math.floor(time*0.5);
    }

    @Override
    public double getVolumeOfCuboid(double length, double width, double height) {
        return length*width*height;
    }

    @Override
    public float mpgToKPM(float mpg) {
        
      final float mls_to_km = 1.609344f;
      final float gal_to_lit = 4.54609188f;
      float kpl = (mpg * mls_to_km) / gal_to_lit;
      kpl = Math.round(kpl * 100.0f) / 100.0f;
      return kpl;
        
    }

    @Override
    public int[] squareOrSquareRoot(int[] array) {
       for(int i = 0; i < array.length; i++) {
          double number = Math.sqrt(array[i]);
          if(number == Math.round(number)) {
              array[i] = (int)number;
          } else {
              array[i] *= array[i];
          }

      }
      return array;
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
        return new int[0];
    }

    @Override
    public boolean am_i_wilson(double n) {
        return false;
    }
}
