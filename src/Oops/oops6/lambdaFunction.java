package Oops.oops6;

import java.util.ArrayList;
import java.util.function.Consumer;

public class lambdaFunction {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i=0;i<5;i++){
            arr.add(i+1  );
        }
        //arr.forEach((item)-> System.out.println(item*2));//item represents every single element in arr
        //or u can write
        Consumer<Integer> fun=(item)-> System.out.println(item*2);
        arr.forEach(fun);//till here
        //below diff program
        Operation sum=(a,b)->a+b;//rteurns a+b
        Operation prod=(a,b)->a*b;
        Operation sub=(a,b)->a-b;
        lambdaFunction mycalculator=new lambdaFunction();
        System.out.println(mycalculator.opearte(5,3,sum));
    }
    private int opearte(int a ,int b,Operation op){
        return op.operation(a,b);

    }
    interface Operation{
        int operation(int a, int b);
    }

}
