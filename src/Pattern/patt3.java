package Pattern;

public class patt3 {
    public static void main(String[]args){

        pattern(5);
    }
    static void pattern(int n){
        for(int i=1;i<=n;i++){
            int numb=1;
            for(int j=1;j<=i;j++){
                System.out.print(numb++);

            }
            System.out.println();
        }
    }

}

