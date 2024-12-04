package org.academy.kata.implementation.BasilJaworski;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        double result = 0.0;
        double div = 1.0;

        for (int i=0; i<n; i++){
            result += 1 / div;
            div += 3.0;
        }

        return String.format("%.2f", result);
    }
}
