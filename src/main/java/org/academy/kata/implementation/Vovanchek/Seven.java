package org.academy.kata.implementation.Vovanchek;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double count = 0;
        for(double elem : arr) {
              count += elem;
          }
      
        double result = navg * (arr.length + 1) - count;
      
        if (result <= 0) {
            throw new IllegalArgumentException("Expected donation is not positive.");
        }
      

        return (long) Math.ceil(result);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
