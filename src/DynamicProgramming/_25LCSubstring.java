package DynamicProgramming;

public class _25LCSubstring {
    //tabulation
    static int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int [][]dp=new int[n+1][m+1];
        int ans=0;

        for(int i=1;i<=n;i++){
            for (int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    int val=1+dp[i-1][j-1];
                    dp[i][j]=val;
                    ans=Math.max(ans,val);
                }else {
                    dp[i][j]=0;
                }
            }
        }
        return ans;
    }

    //space
    static int lcs2(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        int prev[]=new int[m+1];
        int cur[]=new int[m+1];
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    int val=1+prev[j-1];
                    cur[j]=val;
                    ans=Math.max(ans,val);
                }else {
                    cur[j]=0;
                }
            }
            prev=cur.clone();
        }
        return ans;
    }
    public static void main(String args[]) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Substring is " + lcs(s1, s2));
        System.out.println("The Length of Longest Common Substring is " + lcs2(s1, s2));

    }
}
