import java.util.ArrayList;

public class linearsearch_arraylist3 {
    public static void main(String[] args) {
        int []arr={1,2,4,4,5};
        System.out.println(findindex(arr,4,0));
    }
    static ArrayList<Integer> findindex(int[]arr, int target, int index){
        ArrayList<Integer> list= new ArrayList<>();
        if(index==arr.length){
            return list;
        }
        //this will contain ans for that fn call only
        if(arr[index]==target){
            list.add(index);
        }
        ArrayList<Integer> ansfrombelow= findindex(arr,target,index+1);
        list.addAll(ansfrombelow);
        return list;
    }
}
