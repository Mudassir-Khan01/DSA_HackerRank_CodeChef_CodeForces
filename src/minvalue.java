import java.util.Scanner;
public class minvalue {
    public static void main(String[]args)
    {
        int [] arr;

        Scanner sc=new Scanner(System.in);

        System.out.println("How many numbers you wanna enter");
        int a=sc.nextInt();
        arr=new int[a];
        System.out.format("enter %d numbers",a);
        for(int i=0; i<a ; i++)
        { arr[i]=sc.nextInt();
        }
        int min=Integer.MAX_VALUE;
        for(int e:arr){
            if(e < min){
                min = e ;
            }
        }
        System.out.println("Min value is "+min);

    }
}

