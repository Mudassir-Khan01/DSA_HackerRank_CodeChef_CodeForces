public class countsteps_recur {
    public static void main(String[] args) {
        System.out.println(count(14));
    }
    static int count(int n){
        return helper(n,0);
    }
    static int helper(int n,int c){
        if(n==0){
            return c;
        }
        if(n%2==0){
            return helper(n/2,c+1);
        }else{
            return helper(n-1,c+1);
        }
    }


}
