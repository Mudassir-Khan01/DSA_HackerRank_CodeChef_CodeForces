import java.util.Arrays;

public class missingnumb_cycle {
    public static void main(String[] args) {
        int[] arr = {3,0,1};
int ans=missing(arr);
System.out.println(ans);
    }

    static int missing(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }
        //search for fierst missing element
        for (int index = 0; index < arr.length;index++ ) {
            if (arr[index] != index) {
                return index;
            }
        }
        return arr.length;//case 2
    }
}


