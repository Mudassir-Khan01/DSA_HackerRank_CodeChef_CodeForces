public class pallindrome {
    public static void main(String[] args) {
String str="abccba";
System.out.println(ispalin(str));
    }
    static boolean ispalin(String str){
        if(str==null||str.length()==0){
            return true;
        }
        str=str.toLowerCase();
        for(int i=0;i<=str.length()/2;i++){//since we r going through half of the array
            char start=str.charAt(i);
            char end=str.charAt(str.length()-1-i);
            if(start!=end){
                return false;
            }
        }
        return true;
    }
}
