public class NQueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][]board=new boolean[n][n];
queens(board,0);
    }
    static int queens(boolean[][]board,int row){
        if(row== board.length){//no more rows for queen
            display(board);
            System.out.println();
            return 1;
        }
        int count=0;
        //placing queen and checking for every row and col
        for(int col=0;col<board.length;col++){
            //palce the queen if it is safe
            if(isSafe(board,row,col)){
                board[row][col]=true;//first row is placed
                count +=queens(board,row +1);//now look for remianing row
                board[row][col]=false;
            }

        }
        return count;
    }
    static boolean isSafe(boolean[][]board,int row ,int col) {
        //check vertical row
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {//if true means queen is there
                return false;
            }
        }
        //diagonal left
        int maxleft = Math.min(row, col);
        for (int i = 1; i <= maxleft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        int maxright = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxright; i++) {
            if (board[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }
     static void display(boolean[][]board){
        for (int i = 0; i < board.length; i++) {
            boolean[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                boolean element = row[j];
                if (element) {
                    System.out.print("Q");
                }else{
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }
}
