import java.util.ArrayList;

public class linearsearch_arraylist {
    public static void main(String[] args) {
int []arr={1,2,3,4,4,5};
int target=4;
linear(arr,target,0);
        System.out.println(list);

    }
    static ArrayList<Integer> list=new ArrayList<>();
    static void linear(int []arr,int target,int index){
        if(index==arr.length){
            return;
        }
        if(arr[index]==target){
            list.add(index);
        }
        linear(arr,target,index+1);
        }
    }

