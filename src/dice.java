import java.util.ArrayList;

public class dice {
    public static void main(String[] args) {
dicee("",4);
        System.out.println(diceeRR("",4));
    }
    static void dicee(String p,int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1; i<=6&&i<=target;i++){
            dicee(p+i,target-i);
        }
    }

    static ArrayList<String> diceeRR(String p, int target){
        if(target==0){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String>ans=new ArrayList<>();
        for(int i=1; i<=6&&i<=target;i++){
           ans.addAll(diceeRR(p+i,target-i));

        }
        return ans;
    }
}
