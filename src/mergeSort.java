import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
    int []arr={100,90,80,70,60,50,40};
    int []ans=mergersort(arr);
        System.out.println(Arrays.toString(ans));
    }
    static int [] mergersort(int []arr){
        if(arr.length==1){
            return arr;
        }
        int mid=arr.length/2;
        int[] left=mergersort(Arrays.copyOfRange(arr,0,mid));
        int [] right=mergersort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }
   private static int[]merge(int []first,int []second){
        int[]  mix=new int[first.length+second.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<first.length&&j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }
            else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }
        //it may be possible that one might not be complete
        //add all the remaining elements or copy the remaining elements
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }
        while(j<second.length){
            mix[k]=first[j];
            j++;
            k++;
        }
        return mix;

    }
}
