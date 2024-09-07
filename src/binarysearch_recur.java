public class binarysearch_recur {
    public static void main(String[] args) {
int[]arr={1,2,3,4,5};
int target=0;
System.out.println(rcur(arr,target,0,arr.length-1));
    }
    static int rcur(int[]arr,int target,int s,int e){//s and e needs to be passed son they are in the arguments
        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(arr[m]==target){
            return m;
        }
        if(target<arr[m]){
            return rcur(arr,target,s,m-1);
        }else{
            return rcur(arr,target,m+1,e);
        }


    }

}
