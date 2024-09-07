import java.util.ArrayList;

public class permutation {
    public static void main(String[] args) {
        permu("","abc");
        System.out.println(permut("","abc"));
        System.out.println(permucount("","abc"));
    }
    static void permu(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            permu(f+ch+s,up.substring(1));
        }
    }
    //using arraylist
    static ArrayList<String> permut(String p,String upp){
       if(upp.isEmpty()){
           ArrayList<String> list=new ArrayList<>();
           list.add(p);
           return list;
       }
        char ch=upp.charAt(0);
       ArrayList<String> ans=new ArrayList<>();
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());

            ans.addAll(permut(f+ch+s,upp.substring(1)));

        }
        return ans;
    }

    static int permucount(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            count =count+permucount(f+ch+s,up.substring(1));
        }//every return of 1 should be added
    return count;
    }
}
