package Oops.oops6;

import java.util.ArrayList;
import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        comparisonObject Kunal=new comparisonObject(1,98);
        comparisonObject RAhul=new comparisonObject(2,99);
        if(Kunal.compareTo(RAhul)<0){
            System.out.println(Kunal.compareTo(RAhul));
            System.out.println("Rahhul has more marks");

            comparisonObject kaye=new comparisonObject(1,99);
            comparisonObject Mudassir=new comparisonObject(2,78);
            comparisonObject arkaam=new comparisonObject(1,86);
            comparisonObject vipul=new comparisonObject(1,92);
            comparisonObject[]list={kaye,Mudassir,arkaam,vipul};
            System.out.println(Arrays.toString(list));
            Arrays.sort(list);
            System.out.println(Arrays.toString(list));

        }
    }
}
