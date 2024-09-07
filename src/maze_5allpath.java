public class maze_5allpath {
    public static void main(String[] args) {
        boolean[][]board={
                {true,true,true},
                {true,true ,true},
                {true,true,true}
        };
        allpath("",board,0,0);
    }

    static void allpath(String p,boolean [][]maze, int r, int c) {
        if (r == maze.length-1 && c == maze[0].length-1) {
            System.out.println(p);
            return;
        }
        if(maze[r][c]==false) {
            return;
        }
        //i am considering this block in my path
        maze[r][c]=false;
        if (r < maze.length-1) {//agar row bada so go down
            allpath(p + 'D',maze, r + 1, c);
        }
        if (c<maze[0].length-1) {//agar col bada so go right
            allpath(p + 'R',maze, r, c +1);

        }
        if(r>0){//up
            allpath(p+'U',maze,r-1,c);
        }
        if(c>0){
            allpath(p+'L',maze,r,c-1);
        }
        //this line is where the function will be over
        //so before fn gets removed , also remove the changes that were made by that function
        maze[r][c]=true;
    }
}
