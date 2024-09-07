package Graph;

public class _37FloydWarshal {
    public void shortest_distance(int [][] matrix){
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==-1){//just traverse the whole matrix if
                    // its unreachable just make it a very larger value
                    matrix[i][j]=(int )1e9;
                }
                if(i==j) matrix[i][j]=0;
            }
        }
        //main code
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        //opposite of the first iteration
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(matrix[i][j]==(int)1e9){
                    matrix[i][j]=-1;
                }
            }
        }
        //for -ve cycle
        for(int i=0;i<n;i++){
            if(matrix[i][i]<0){
                System.out.println("-ve cycle found");
            }
        }


    }
    public static void main(String[] args) {
        int V = 4;
        int[][] matrix = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                matrix[i][j] = -1;
            }
        }

        matrix[0][1] = 2;
        matrix[1][0] = 1;
        matrix[1][2] = 3;
        matrix[3][0] = 3;
        matrix[3][1] = 5;
        matrix[3][2] = 4;

        _37FloydWarshal obj = new _37FloydWarshal();
        obj.shortest_distance(matrix);

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
