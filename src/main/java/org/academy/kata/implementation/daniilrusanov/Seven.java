package org.academy.kata.implementation.daniilrusanov;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        double res = 0;
        double divisor = 1;
        for (int i = 0; i < n; i++) {
            res += 1 / divisor;
            divisor += 3;
        }

        return String.format("%.2f", res);
    }
}
