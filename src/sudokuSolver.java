public class sudokuSolver {
    public static void main(String[] args) {
int[][]board=new int[][]{
        {3,0,6,5,0,8,4,0,0},
        {5,2,0,0,0,0,0,0,0},
        {0,8,7,0,0,0,0,3,1},
        {0,0,3,0,1,0,0,8,0},
        {9,0,0,8,6,3,0,0,5},
        {0,5,0,0,9,0,6,0,0},
        {1, 3, 0, 0, 0, 0, 2, 5, 0},
        {0,0,0,0,0,0,0,7,4},
        {0,0,5,2,0,6,3,0,0}

};
if(solve(board)){
    display(board);
}else{
    System.out.println("Cannt solve ");
}
    }
    static boolean solve(int[][]board){
        int n = board.length;
        int row=-1;//initially
        int col=-1;
        boolean emptyleft=true;
        //this ismhow we are replacing r ,c from arguments
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==0){
                    row=i;
                    col=j;
                    emptyleft=false;//no space there
                    break;//found one potential ans so break
                }
            }
            //when u have treversed the entire row
            //if u found some empty element in row,then break
            if(emptyleft==false){
                break;
            }
        }
        if(emptyleft==true){//no empty found
            return true;//suduko is solved
        }
        //backtrack
        for(int number=1;number<=9;number++ ){
            if(issafe(board,row,col,number)){
                board[row][col]=number;
                if(solve(board)==true){

                    return true;
                }else{
                    //backtrack
                    board[row][col]=0;
                }
            }
        }
        return false;
    }
    static void display(int [][]board){
        for(int[]row:board){
            for(int num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    static boolean issafe(int [][]board,int row,int col,int num){
        //check the row
        for(int i=0;i< board.length;i++){
            //check if the no. is in the row or not
            if(board[row][i]==num){//if no. is there return false
                return false;
            }
        }
        //check for the column
        for (int i = 0; i < board.length; i++) {
            int[] nums = board[i];//same column for different rows
            //check if the no. is in the col or not
            if (nums[col] == num) {//if no. is there return false
                return false;
            }
        }
            int sqrt=(int)(Math.sqrt(board.length));
            int rowstart=row-row%sqrt;
            int colstart=col-col%sqrt;
            for(int r=rowstart; r<rowstart+sqrt;r++ ){
                for(int c=colstart;c<colstart+sqrt;c++){
                     if(board[r][c]==num){
                         return false;
                     }
                }
            }
            return true;
        }
    }


