import java.util.Scanner;
public class multitable {
    static void multiplication(int n){
        for(int i=1;i<=10;i++){
            System.out.format("%d x %d = %d \n",n,i,n*i);
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int n=sc.nextInt();
        multiplication(n);
    }
}
