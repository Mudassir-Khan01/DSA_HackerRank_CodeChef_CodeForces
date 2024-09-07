import java.util.Arrays;

public class cyclesort {
    public static void main(String[] args) {
int[]arr={10,8,7,6,9,4,1,2,3,5};//for contiinous arary starting from 1
cycle(arr);
System.out.println(Arrays.toString(arr));
    }
    static void cycle(int[]arr){
        int i=0;
        while(i<arr.length){
            int correct=arr[i]-1;
            if(arr[i]!=arr[correct]){
                int temp=arr[i];
                arr[i]=arr[correct];
                arr[correct]=temp;
            }else{
                i++;//else move ahead
            }
        }
    }
}
