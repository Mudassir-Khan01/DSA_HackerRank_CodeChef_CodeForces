public class maze_4obstacle  {
    public static void main(String[] args) {
boolean[][]board={
        {true,true,true},
        {true,false,true},
        {true,true,true}
};
        path("",board,0,0);
    }
    static void path(String p,boolean [][]maze, int r, int c) {
        if (r == maze.length-1 && c == maze[0].length-1) {
            System.out.println(p);
            return;
        }
        if(maze[r][c]==false) {
            return;
        }
        if (r < maze.length-1) {//agar row bada so go down
            path(p + 'D',maze, r + 1, c);
        }
        if (c<maze[0].length-1) {//agar col bada so go right
            path(p + 'R',maze, r, c +1);
        }
    }
}
