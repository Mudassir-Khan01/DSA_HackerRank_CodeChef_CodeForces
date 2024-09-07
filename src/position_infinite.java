public class position_infinite {
    public static void main(String[]args){
int []arr={3,5,6,7,10,12,14,16,18,22,24,34,45,56,78,89};
int target=56;
System.out.println(ans(arr,target));
    }
    static int ans(int[]arr,int target){
        //first find the range
        //first start with a box of 2 so start 0 and end 1
        int start=0;
        int end=1;

        while(target>arr[end]){
            int newStart=end+1;
            //double the end....end =previous +sizeofbox*2
            end=end+(end-start+1)*2;
            start=newStart;
        }
        return binarysearch(arr,target,start,end);
    }
    static int binarysearch(int []arr,int target,int start,int end){


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;

            }
        }
        return -1;
    }
    }

