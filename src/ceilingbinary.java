public class ceilingbinary {
    public static void main(String[]args){
        int []arr={-18,-12,-1,0,1,2,3,4,5,6,7};
        int target= -11;
        int ans= ceiling(arr,target);
        System.out.println(arr[ans]+"and the index is "+ans);
    }
    static int ceiling(int[]arr, int target){
        int start=0;
        int end=arr.length-1;
        if(target>arr[arr.length-1]){
            return -1;
        }



        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }
                if(target<arr[mid]){
                    end=mid-1;
                }else if(target>arr[mid]){
                    start=mid+1;


            }
        }
        return start;
    }
}

