public class  facto {

        static int fact(int n){
            if(n==0||n==1) {
                return 1;
            }
            else{
                int product =1;
                for(int i=1;i<=n;i++){
                    product*=i;
                }
                return product;
            }
        }
        public void main(String[]args){
            int n=4;
            int a=fact(n);
            System.out.println(a);
        }
    }


