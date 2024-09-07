import java.util.Scanner;
public class maxvalue {
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
        int max=Integer.MIN_VALUE;
        for(int e:arr){
            if(e > max){
                max = e ;
            }
        }
        System.out.println("Max value is "+max);

}
}

