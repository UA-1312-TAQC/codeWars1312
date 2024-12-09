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
        if(n == 0) {
          return "0.00";
        }
				int s = 0;
        double counter = 1;
        for(double i = 1; s < n; i += 3) {
            counter += 1 / i;
            s++;
        }
        String result = String.format("%.2f", counter - 1);
        return result;
    }
}
