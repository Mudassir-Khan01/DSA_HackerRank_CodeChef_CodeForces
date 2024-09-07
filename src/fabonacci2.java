public class fabonacci2 {
    static int recur(int n){
        if(n<=1){
            return n;
        }else
        return recur(n-2)+recur(n-1);
    }
    public static void main(String[]args){
        int maxnumber=10;
        System.out.print("Fabonacci series of"+maxnumber+"numbers :");
        for(int i=0;i<maxnumber;i++){
            System.out.print(recur(i)+" ");

        }
        int ans=recur(4);
        System.out.println("the number is "+ans);
    }
}
