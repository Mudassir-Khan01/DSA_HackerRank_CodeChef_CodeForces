package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class _40LISPrint {
    static int longest(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] hash = new int[n];
        Arrays.fill(hash, 1);

        for (int i = 0; i <= n - 1; i++) {
            hash[i] = i;//initalizing with the current index

            for (int prev = 0; prev <= i - 1; prev++) {
                if (arr[prev] < arr[i] && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
        }
        int ans = -1;
        int lastindex = -1;
        for (int i = 0; i <= n - 1; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastindex = i;
            }
        }
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[lastindex]);
        while (hash[lastindex] != lastindex) {//till not reavcing the initalization value
            lastindex = hash[lastindex];
            temp.add(arr[lastindex]);
        }
//revrse the array
        for (int i = temp.size() - 1; i >= 0; i--) {
            System.out.print(temp.get(i) + "");
        }
        System.out.println();
        return ans;
    }
    public static void main(String args[]) {

        int arr[] = {10,9,2,5,3,7,101,18};

        int n = arr.length;
        longest(arr,n);

    }
}
