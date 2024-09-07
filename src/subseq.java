import java.util.ArrayList;
import java.util.Arrays;

public class subseq {
    public static void main(String[] args) {
//sub("","abc");
        System.out.println(subarr("","abc"));
    }
    static void sub(String p,String up){
        if(up.isEmpty()){//base condition
            System.out.println(p);//if unprocessed is empty print processed
        return;
        }
        char ch=up.charAt(0);
        sub(p+ch,up.substring(1));
        sub(p,up.substring(1));
    }
// using arraylist
    static ArrayList<String> subarr(String p, String up){
        if(up.isEmpty()){//base condition
            ArrayList<String>list= new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String>left= subarr(p+ch,up.substring(1));
        ArrayList<String>right=subarr(p,up.substring(1));
        left.addAll(right);
        return left;
    }
}
