public class agonsticbinary {
    public static void main(String[]args){
        int []arr={-18,-12,-1,0,1,2,3,4,5,6,7};
        int target=2;
        int ans= agno(arr,target);
System.out.println(ans);
    }
    static int agno(int[]arr, int target){
        int start=0;
        int end=arr.length-1;

        boolean isAsc=arr[start]<arr[end];

        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }

            if(isAsc){
                if(target<arr[mid]){
                    end=mid-1;
                }else if(target>arr[mid]){
                    start=mid+1;
                }
            }else{
                if(target<arr[mid]){
                    start=mid+1;
                }else if(target>arr[mid]){
                        end=mid-1;
                }
            }
        }
        return -1;
    }
}
