import java.util.ArrayList;

public class letter_combination_phone {
    public static void main(String[] args) {
        System.out.println(phone("","12"));
        System.out.println(count("","12"));
        //u can use this method too
        System.out.println(phone("","12").size());

    }
    static void pad(String p ,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit=up.charAt(0 )-'0';//this will convert '2'into 2
        for(int i=(digit-1)*3;i<digit*3;i++){
            char ch=(char)('a'+i);
            pad(p+ch,up.substring(1));
        }
    }
    static ArrayList<String> phone(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit=up.charAt(0)-'0';
        ArrayList<String> ans=new ArrayList<>();
        for(int i=(digit-1)*3;i<digit*3;i++){
            char ch=(char)('a'+i);
            ans.addAll(phone(p+ch,up.substring(1)));
        }
        return ans;
    }

    static int count(String p ,String up){
        if(up.isEmpty()){

            return 1;
        }
        int count=0;
        int digit=up.charAt(0 )-'0';//this will convert '2'into 2
        for(int i=(digit-1)*3;i<digit*3;i++){
            char ch=(char)('a'+i);
            count =(int)(count+count(p+ch,up.substring(1)));
        }
        return count;
    }
}
