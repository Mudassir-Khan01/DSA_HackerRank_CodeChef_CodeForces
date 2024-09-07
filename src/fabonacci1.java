public class  fabonacci1 {
    public static void main(String []args){
        int maxnumber=10;
        int prev=0;
        int next=1;
        System.out.print("Fabo nacci series of "+maxnumber +"numbers are");
        for(int i=1;i<=maxnumber;++i){
            System.out.print(prev+"");
            int sum=prev+next;
            prev=next;
            next=sum;
        }
    }
}
