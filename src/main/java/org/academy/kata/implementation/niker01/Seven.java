package org.academy.kata.implementation.niker01;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
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
