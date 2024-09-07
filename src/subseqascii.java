import java.util.ArrayList;

public class subseqascii {
    public static void main(String[] args) {
        System.out.println(subseq("","ab"));

    }
    static ArrayList<String> subseq(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list =new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String>first=subseq(p+ch,up.substring(1));
        ArrayList<String>second=subseq(p,up.substring(1));
        ArrayList<String>third=subseq(p+(ch+0),up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }
}
