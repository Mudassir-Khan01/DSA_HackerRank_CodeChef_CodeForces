import java.util.Arrays;

public class selectio {
    public static void main(String[] args) {
int []arr={5,4,3,2,1};
selectionsort(arr);
System.out.println(Arrays.toString(arr));
    }
    static void selectionsort(int []arr){
        for (int i=0;i<arr.length;i++){
            int last=arr.length-i-1;
            int maxindex=getmatindex(arr,0,last);
            swap(arr,maxindex,last);
        }
    }
    static void swap(int []arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
    static int getmatindex(int[]arr,int start,int end){
     int max=0;
     for(int i=start;i<=end;i++){
         if(arr[max]<arr[i]){
             max=i;
         }
     }return max;
    }
}
