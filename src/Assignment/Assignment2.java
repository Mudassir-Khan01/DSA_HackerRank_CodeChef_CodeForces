package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Assignment2 {
    static Scanner sc=new Scanner(System.in);

    //1
    public static int[] sort(int []arr){
        int temp;
        for(int i=0;i<arr.length;i++) {
            for (int j = 1; j <= arr.length - i - 1; j++) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        return arr;
    }

    //2
    public static int reverse(int x){
        int ans=0;
        while (x>0){
            int rem=x%10;
            x/=10;
            ans=ans*10+rem;
        }
        return ans;
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
    public static int digit(int n){
        int count=0;
        while(n>0){
            n/=10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {

        //1
        System.out.println("how many numbers you want to enter in array");
        int a= sc.nextInt();
        int []arr=new int[a];
        System.out.println("Enter "+a+" numbers");
        for (int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
        }
        sort(arr);
        System.out.println(Arrays.toString(arr));

        //2
        System.out.println("Enter a number to be reversed");
        int x= sc.nextInt();
        System.out.println(reverse(x));

        //3
        System.out.println("Enter number to check whether it is prime or not");
        System.out.println(prime(sc.nextInt()));

        //4
        System.out.println("Enter a no. to find how many digits it has");
        int n= sc.nextInt();
        System.out.println(digit(n));
    }
}
