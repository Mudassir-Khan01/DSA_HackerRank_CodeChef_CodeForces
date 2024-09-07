import java.util.ArrayList;

public class linearsearch_arraylist2 {
    public static void main(String[] args) {
int []arr={1,2,4,4,5};
int target=4;
ArrayList<Integer>ans=findindex(arr,target,0,new ArrayList<>());
        System.out.println(ans);
    }
    static ArrayList<Integer> findindex(int[]arr,int target,int index,ArrayList<Integer>list){
        if(index==arr.length){
            return list;
        }
        if(arr[index]==target){
            list.add(index);
        }
        return findindex(arr,target,index+1,list);
    }
}
