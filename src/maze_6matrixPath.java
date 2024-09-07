import java.util.Arrays;

public class maze_6matrixPath {
    public static void main(String[] args) {
        boolean[][]board={
                {true,true,true},
                {true,true ,true},
                {true,true,true}
        };
        int[][]path=new int[board.length][board[0].length];
        allpath("",board,0,0,path,1);
    }
    static void allpath(String p,boolean [][]maze, int r, int c,int [][]path,int step) {
        if (r == maze.length-1 && c == maze[0].length-1) {
            path[r][c]=step;
            for (int i = 0; i < path.length; i++) {
                int[] arr = path[i];
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(maze[r][c]==false) {
            return;
        }
        //i am considering this block in my path
        maze[r][c]=false;
        path[r][c]=step;
        if (r < maze.length-1) {//agar row bada so go down
            allpath(p + 'D',maze, r + 1, c,path,step+1);
        }
        if (c<maze[0].length-1) {//agar col bada so go right
            allpath(p + 'R',maze, r, c +1,path,step+1);

        }
        if(r>0){//up
            allpath(p+'U',maze,r-1,c,path,step+1);
        }
        if(c>0){
            allpath(p+'L',maze,r,c-1,path,step+1);
        }
        //this line is where the function will be over
        //so before fn gets removed , also remove the changes that were made by that function
        maze[r][c]=true;
        path[r][c]=0;
    }
}
