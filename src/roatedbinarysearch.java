public class roatedbinarysearch {
    public static void main(String[] args) {
int[]arr={4,5,6,7,0,1,2};
int target=7;

int ans=firstlast(arr,target);
System.out.println(ans);
    }
    static int firstlast(int[]arr,int target){
        int pivot=findpivot(arr);
        if(pivot==-1){//normal binary search no rotation
            return search(arr,target,0,arr.length-1);
        }
        if(arr[pivot]==target){
            return pivot;
        }
        if(pivot>0){
        int first=search(arr,target,0,pivot-1);
        if(first!=-1){
            return first;
        } else{
            int last=search(arr,target,pivot+1,arr.length-1);
            return last;
        }}return -1;
    }
    static int search(int[]arr,int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            } else if(target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }
        }
        return -1;
    }
    static int findpivot(int[]arr) {
        int start = 0;
        int end = arr.length;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //now write 4 cases
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
           /* if (arr[mid] <= arr[start]) {
            //this is for no duplicate elements
                end = mid - 1;
            } else if (arr[mid] > start) {
                start = mid + 1;
            }*/
            //if elememts at middle start end are equal then just skip the duplicate
if(arr[mid]==arr[start]&&arr[mid]==arr[end]){
    //skip the duplicate
    //check if start is pivot
    if(arr[start]>arr[start+1]){
        return start;
    }
    start++;

    //check wherether end is pivot
    if(arr[end]<arr[end-1]){
        return end-1;
    }
    end--;
}
//left side is sorted ,so pivot should be in right
            else if(arr[start]<arr[mid]||(arr[start]==arr[mid]&&arr[mid]>arr[end])){
                start=mid+1;

            }else{
                end=mid-1;
            }
        }
        return -1;
    }
}
