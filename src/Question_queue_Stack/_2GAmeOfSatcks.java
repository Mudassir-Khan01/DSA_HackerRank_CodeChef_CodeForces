package Question_queue_Stack;

import java.util.Arrays;
import java.util.Scanner;

public class _2GAmeOfSatcks {
    static int twoStacks (int x,int []a,int[]b) {//x is the sumwhich cant be exceed and 2 arrays
        return twoStacks(x, a, b, 0, 0) - 1;//like in example 5 is actually where the condition broke so we ahve to decrease it by one
    }
        private static int twoStacks(int x,int []a,int[]b,int sum,int count){
        if(sum>x){
            return count;
        }
        if(a.length==0||b.length==0){
            return count;
        }
        int ans1=twoStacks(x, Arrays.copyOfRange(a,1,a.length),b,sum+a[0],count+1);
        //copy of range means in array a take from index 1 till length and b remains as it is and sum+value at 0 which we picked
        int ans2=twoStacks(x,a,Arrays.copyOfRange(b,1,b.length),sum+b[0],count+1);
        return Math.max (ans1,ans2);

        }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){//how many times u wanna perform this
            int n=sc.nextInt();//size of a arrAY
            int m=sc.nextInt();//size of b array
            int x=sc.nextInt();//max sum
            int []a=new int[n];
            int b[]=new int[m];
            for(int j=0;j<n;j++){
                a[j]=sc.nextInt();
            }
            for(int j=0;j<m;j++){
                b[j]=sc.nextInt();
            }
            System.out.println(twoStacks(x,a,b));


        }
    }
}
