public class PEAKmountain {
    public static void main(String[]args){
int []arr={0,1,2,3,82,89,2,1};
int ans=peakIndex(arr);
System.out.println("index is "+ans+"and its value is "+arr[ans]);
    }
    public static int peakIndex(int[]arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int mid = start +(end-start)/2;
            if(arr[mid]>arr[mid+1]) {
                 end=mid;
            }else{
                start=mid+1;
            }
        }
return start;
    }
}
