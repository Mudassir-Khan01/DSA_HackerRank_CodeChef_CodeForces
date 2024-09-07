public class sumofdigit_recur {
    public static void main(String[] args) {
int ans=sum(1342);
        System.out.println(ans);
    }
    static int sum(int n){
        int rem=n%10;
        int div=n/10;
        if(n==0){
            return 0;
        }
        return rem+sum(div);

    }
}
