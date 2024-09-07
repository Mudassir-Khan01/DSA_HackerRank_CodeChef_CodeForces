package Pattern;

public class patt8 {
    public static void main(String[] args) {
        psttern(4);

    }

    static void psttern(int n) {
        int original=n;
        n = 2 * n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryindex = Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryindex);
            }
            System.out.println();
        }
        patternn(original);
    }//left=col; right=n-col
//up=row;//down=n-row

    static void patternn(int n){
        n= 2 * n;
        int original=n;
        for (int row = 0; row <= n; row++) {
            for (int col = 0; col <= n; col++) {
                int atEveryindex = original-Math.min(Math.min(row, col), Math.min(n - row, n - col));
                System.out.print(atEveryindex);
            }
            System.out.println();
        }
    }

}

