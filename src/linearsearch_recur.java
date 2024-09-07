public class linearsearch_recur {
    public static void main(String[] args) {
        int []arr={1,2,3,4,5};
        int target=5;
        System.out.println(linear(arr,target,0));
        System.out.println(indexlinear(arr,target,0));
    }

    static boolean linear(int []arr,int target,int index){
        if(index==arr.length){
            return false;
        }
        return arr[index]==target || linear(arr,target,index+1);
    }
    //for finding index
    static int indexlinear(int []arr,int target,int index){
        if(index==arr.length){
            return -1;
        }
       if(arr[index]==target ) {
           return index;
       }else{
           return indexlinear(arr,target,index+1);
       }
    }
}
