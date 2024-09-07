package Pattern;

public class patt2 {
    public static void main(String[]args){
        int n=4;
        for(int i=1;i<=n;i++){ //rows
            for(int j=n;j>=i;j--){//stars
                System.out.print("*");

            }
            System.out.println();
        }
    }
}
