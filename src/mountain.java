public class mountain {
    public static void main(String[]args){
        int[]arr={1,2,3,4,5,3,1};//asc peak desc
        int target=3;
        int ans=search(arr,target);
        System.out.println(ans);

    }
    static int search(int[]arr,int target){
        int peak=peakIndex(arr);
        int asc=agno(arr,target,0,peak);
        if(asc!=-1){
            return asc;
        }else{
            int desc=agno(arr,target,peak+1,arr.length-1);
            return desc;
        }

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

    static int agno(int[]arr, int target,int start,int end){


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
