public class sumrecur {
    static int sum(int n){
        if(n==1){
            return 1;
        }
        return n+sum(n-1);
    }
    public static void main(String[]args){
        int s = sum(5);
        System.out.println("Sum is "+s);
    }
}
