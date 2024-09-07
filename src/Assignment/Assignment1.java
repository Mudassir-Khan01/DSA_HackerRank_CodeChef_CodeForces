package Assignment;

import java.util.Scanner;

public  class Assignment1 {
    static Scanner sc=new Scanner(System.in);
    //1
     public static int sum( ){
        System.out.println("Enter any positive interger ");
        int n=sc.nextInt();
        int rem;
        int sum=0;
        while(n>0){
            rem=n%10;
            sum=sum+rem;
            n=n/10;
        }
        return sum;
    }
    //2
    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }else{
            return fibonacci(n-2)+ fibonacci(n-1);
        }
    }
    //3
    public static boolean prime(int n){
        if(n<=1){
            return false;
        }
        int c=2;
        while(c*c<=n){
            if(n%c==0){
                return false;
            }
            c++;
        }
       return true;
    }
    //4
    public static void Largest_smallest(int[]arr){
         int max=Integer.MIN_VALUE;
         for(int i=0;i<arr.length;i++){
             if(arr[i]>max){
                 max=arr[i];
             }
         }
        System.out.println("Largest element is "+max);
         int min=Integer.MAX_VALUE;
         for(int i=0;i<arr.length;i++){
             if(arr[i]<min){
                 min=arr[i];
             }
         }
        System.out.println("Smallest element is "+min);
    }
    public static void main(String[] args) {
         //1
        System.out.println("Sum of its digit is "+sum());


         //2
        System.out.println("Enter No.of terms in fibonacci series ");
        int n=sc.nextInt();
        System.out.println("Fibonacci series is");
        for(int i=0;i<n;i++){
            System.out.print(fibonacci(i)+" ");
        }
        System.out.println();


        //3
        System.out.println("Prime till how many no.");
        int a=sc.nextInt();
        for(int i=1;i<=a;i++){
        if(prime(i)) {
            System.out.print(i+" ");
           }
        }
        System.out.println();


        //4
        System.out.println("No. of Integers");
        int x= sc.nextInt();
        int []arr=new int[x];
        System.out.println("Enter "+x+" numbers");
        for (int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
       Largest_smallest(arr);
    }
}
