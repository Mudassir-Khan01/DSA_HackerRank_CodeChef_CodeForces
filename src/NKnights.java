public class NKnights {
    public static void main(String[] args) {
        int n=3;
boolean[][]board=new boolean[n][n];
knight(board,0,0,4);
    }

    static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {//all of them are placed
            display(board);
            System.out.println();
            return;
        }
        if (row == board.length - 1 && col == board.length) {
            return;//if no space left so just return
        }
        if (col == board.length) {
            knight(board, row + 1, 0, knights);
            return;//col end so nxt row
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        knight(board, row, col + 1, knights);//not safe just move ahead
    }

    static boolean isSafe(boolean[][] board, int row, int col) {
if(isvalid(board,row-2,col-1)){
    if(board[row-2][col-1]){
        return false;
    }
}
        if(isvalid(board,row-2,col+1)){
            if(board[row-2][col+1]){
return false;
            }
        }
        if(isvalid(board,row-1,col+2)){
            if(board[row-1][col+2]){
return false;
            }
        }
        if(isvalid(board,row-1,col-2)){
            if(board[row-1][col-2]){
return false;
            }
        }
        return true;
    }

    static boolean isvalid(boolean[][] board, int row, int col) {
if(row>=0&&row<board.length&&col>=0&&col< board.length){//just for ythis condition as we have to use it many times so better ro put it in function
    return true;
}else{
    return false;
}
    }


    static void display(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                boolean element = row[j];
                if (element == true) {
                    System.out.print("K");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }

    }
}
