package org.academy.kata.implementation.MisterV03;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
        double res = 0;
        if(n == 0)
            return "0.00";
        double step = 1;
        for(int i = 1; i<=n; i++){
            res+=1/step;
            step+=3;
        }
        return String.format("%.2f",res);
    }
}
