package DynamicProgramming;

import java.util.*;

public class _42LongestDivisibleSubset {
    static List<Integer> divisibleSet(List<Integer> arr) {
        int n = arr.size();

        Collections.sort(arr);
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 1));
        List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            hash.set(i, i);
            for (int prev = 0; prev <= i - 1; prev++) {
                if (arr.get(i) % arr.get(prev) == 0 && 1 + dp.get(prev) > dp.get(i)) {
                    dp.set(i, 1 + dp.get(prev));
                    hash.set(i, prev);//store the index of that prev guy
                }
            }
        }
        //we need to get the highest number in dp and store that last index
        int ans = -1;
        int lastindex = -1;
        for (int i = 0; i < n; i++) {
            if (dp.get(i) > ans) {
                ans = dp.get(i);
                lastindex = i;
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(arr.get(lastindex));
        while (hash.get(lastindex) != lastindex) {//hash[0]=0
             lastindex = hash.get(lastindex);
            temp.add(arr.get(lastindex));
        }
        Collections.reverse(temp);
        return temp;
    }

    public static void main(String[] args) {

        List<Integer> arr = Arrays.asList(1, 16, 7, 8, 4);

        List<Integer> ans = divisibleSet(arr);

        System.out.print("The longest divisible subset elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
