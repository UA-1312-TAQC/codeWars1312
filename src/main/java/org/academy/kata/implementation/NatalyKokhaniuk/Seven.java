package org.academy.kata.implementation.NatalyKokhaniuk;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        if(navg<=0) {
            System.out.println("\""+navg+"\" should be positive number .");
            return -1;
        }
        String resStr="if donations = [";
        double res= navg * (arr.length+1);
        for(int i=0;i<arr.length;++i){
            if(arr[i]<0){
                System.out.println("All donations should be positive numbers .");
                return -1;}
            resStr+=arr[i];
            if(i != arr.length-1)resStr+=", ";
            res-=arr[i];
        }
        resStr+="] then new_avg(donations, "+ Math.round(navg) +") --> "+Math.round(res);
        System.out.println(resStr);
       if(res<0) throw new IllegalArgumentException();
       return Math.round(res);
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
