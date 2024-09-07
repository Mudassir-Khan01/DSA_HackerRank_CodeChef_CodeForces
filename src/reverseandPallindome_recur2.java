public class reverseandPallindome_recur2 {
    public static void main(String[] args) {
        System.out.println(reverse(1234));
        System.out.println(palin(1234321));
    }//here we have to pass arrgument
    static int reverse(int n){
        int digits=(int)(Math.log10(n)+1);
        return helper(n,digits);
    }
    static int helper(int n,int digits){
        if(n%10==n){
            return n;
        }else{
            int rem=n%10;
            return rem*(int)Math.pow(10,digits-1)+helper(n/10,digits-1);
        }

    }
    static boolean palin(int n){
        if(n==reverse(n)){
            return true;
        }
        return false;
    }


}
