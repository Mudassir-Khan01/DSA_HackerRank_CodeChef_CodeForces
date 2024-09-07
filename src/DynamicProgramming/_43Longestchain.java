package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _43Longestchain {
    static int longestStrChain(List<String> arr){
        int n=arr.size();
        arr.sort(comp);//it was sequence so we have to sort it (if it was subsequence no need of sorting)
        int []dp=new int[n];
        Arrays.fill(dp,1);
        int maxi=1;
        for(int i=0;i<n;i++){
            for(int prev=1;prev<i;prev++){
                if(compare(arr.get(i),arr.get(prev))&&1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                }
            }
            if(dp[i]>maxi){
                maxi=dp[i];
            }
        }
        return maxi;
    }

    static Comparator<String> comp=(s1,s2)->s1.length()-s2.length();//sorts it acc to the length
    //fn to compare two string and check if they form a valid chain
    static boolean compare(String s1, String s2){
        if(s1.length()!=s2.length()+1){
            return false;
        }
        int first=0;//first is pointing to s1
        int second=0;
        while (first<s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {//compare the character
                first++;
                second++;
            } else {
                first++;//s1 is bigger one so just move it ahead if it doesnt match
            }
        }
            return first==s1.length()&&second==s2.length();
    }
    public static void main(String[] args) {
        List<String> words = Arrays.asList("a", "b", "ba", "bca", "bda", "bdca");

        System.out.println("The length of the longest string chain is: " + longestStrChain(words));
    }
}
