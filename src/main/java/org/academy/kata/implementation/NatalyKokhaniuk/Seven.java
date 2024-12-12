package org.academy.kata.implementation.NatalyKokhaniuk;

import org.academy.kata.ISeven;

public class Seven implements ISeven {
    @Override
    public long newAvg(double[] arr, double navg) {
        return 0;
    }

    @Override
    public String seriesSum(int n) {
       if(n==0)return "0.00";
        if(n<1) {
            System.out.println("\""+n+"\" should be a natural number .");
            return null;
        }
        double res=1.00;
        int nn=4;
        String x, resStr=n+" --> 1 ";
        for(int i=1;i<n;i++){
            resStr+="+ 1/"+nn+" ";
            res+=1.0/nn;
            nn+=3;
        }
        res=Math.round(res*100.0)/100.00;
        x=""+res;
        if(Math.round(res)==res) x= Math.round(res)+".00";
        else if(Math.round(res*10)==10*res) x= res+"0";
        resStr+=" --> \""+x+"\"";
        System.out.println(resStr);
        return x;
    }
}
