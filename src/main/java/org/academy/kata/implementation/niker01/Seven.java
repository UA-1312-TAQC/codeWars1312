package org.academy.kata.implementation.niker01;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        double sum = 0;
        for (double i : arr) {
            sum += i;
        }
        int n = arr.length;
        double required = navg * (n + 1) - sum;
        if (required <= 0) {
          throw new IllegalArgumentException("!!!");
        }
        return (int) Math.ceil(required);
    }

    @Override
    public String seriesSum(int n) {
    if(n == 0){
      return "0.00";
    }
    double result = 0;
    double i = 1;
    int count = 0;
    while(count < n){
      result += 1/i;
      i += 3;
      count++;
    }
    return String.format("%.2f", result);
    }
}
