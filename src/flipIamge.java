import java.util.Arrays;

public class flipIamge {
    public static void main(String[] args) {
        int[][] image={{1,0,0},
                {0,1,0},
                {0,0,0}};
        int [][]ans=flip(image);
        System.out.println(Arrays.toString(ans));
    }
   static int [][] flip(int[][] image){
       for (int i = 0; i < image.length; i++) {
           int[] row = image[i];
           for(int j=0;j<(image[0].length+1)/2;j++){
              int temp=row[j]^1;//xor to invert it
              row[j]=row[image[0].length-j-1]^1;
              row[image[0].length-j-1]=temp;
           }

       }
       return image;
   }

}
