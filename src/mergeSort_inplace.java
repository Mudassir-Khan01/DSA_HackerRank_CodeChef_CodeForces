import java.util.Arrays;

public class mergeSort_inplace {
    public static void main(String[] args) {
int[]arr={5,4,3,2,1};
mergersortinplace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }
    static void mergersortinplace(int []arr,int s,int e){
        if(e-s==1){
            return ;
        }
        int mid=(s+e)/2;
         mergersortinplace(arr,s,mid);
         mergersortinplace(arr,mid,e);

         merge(arr,s,mid,e);
    }
    private static void merge(int []arr,int s,int m,int e) {
        int[] mix = new int[e-s];
        int i = s;
        int j = m;
        int k = 0;
        while (i < m && j < e) {
            if (arr[i] < arr[j]) {
                mix[k] = arr[i];
                i++;
            } else {
                mix[k] = arr[j];
                j++;
            }
            k++;
        }
        //it may be posssible that one might not becomploete
        //add all the remaining elemeb   ts or copy thge remaining elements
        while (i < m) {
            mix[k] = arr[i];
            i++;
            k++;
        }
        while (j < e) {
            mix[k] = arr[j];
            j++;
            k++;
        }
        for(int l=0;l<mix.length;l++){
            arr[s+l]=mix[l];//needs to be updated in original array
        }
    }
}
