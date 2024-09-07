public class oddeven_bitwise
{
    public static void main(String[] args) {
        int n=685;
        System.out.println(isodd(n));
    }
    static boolean isodd(int n){
        return (n&1)==1;
    }
}
