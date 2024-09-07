package Graph;

public class _1GFG1 {
    public static void main(String[] args) {
        int n=3,m=3;
        int adj[][]=new int[n+1][n+1];
        //edge 1--2
        adj[1][2]=1;
        adj[2][1]=1;
        //similarly for all
        adj[2][3]=1;
        adj[3][2]=1;
        adj[1][3]=1;
        adj[3][1]=1;

    }
}
