public class squareroot {
    public static void main(String[] args) {
int n=40;
int p=3;//precision for decimal value
        System.out.printf("%.3f" , root(n,p));
    }
    static double root(int n,int p){
        int s=0;
        int e=n;
        double root=0.0;
        while(s<=e){
            int m=s+(e-s);
            if(m*m==n){
                root =m;
                return root;
            }
            if(m*m>n){
                e=m-1;
            }else{
                s=m+1;
            }

        }
        double incr=0.1;
        for(int i=0;i<p;i++ ){
            while(root*root<=n){
                root+=incr;
            }
            root-=incr;
            incr/=10;
        }
return root;
    }
}
