package DynamicProgramming;

import java.util.Arrays;

public class _16CountPartiGivenDiff {
    static int mod=(int )(Math.pow(10,9)+7);
    static int countPartri(int ind,int target,int []arr,int dp[][]){
        if(ind==0){
            if(target==0&&arr[0]==0)
                return 2;
            if(target==0||arr[0]==target)
                return 1;
            return 0;
        }
        if (dp[ind][target]!=-1)
            return dp[ind][target];

        int nottaken=countPartri(ind-1,target,arr,dp);
        int taken=0;
        if(arr[ind]<=target)
            taken=countPartri(ind-1,target-arr[ind],arr,dp);
        return dp[ind][target]=(nottaken+taken)%mod;
    }
    static int countPartitions(int d,int[]arr){
        int n=arr.length;
        int totalsum=0;
        for(int i=0;i<n;i++){
            totalsum+=arr[i];
        }
        //checking some edge cases
        if(totalsum-d<0) return 0;
        if((totalsum-d)%2==1) return 0;

        int s2=(totalsum-d)/2;
        int dp[][]=new int[n][s2+1];
        for(int[]row:dp)
            Arrays.fill(row,-1);

        return countPartri(n-1,s2,arr,dp);
    }
    public static void main(String args[]) {

        int arr[] = {5,2,6,4};
        int d=3;

        System.out.println("The number of subsets found are "+countPartitions(d,arr));
        System.out.println("The number of subsets found are "+countPartitions2(d,arr));
        System.out.println("The number of subsets found are "+countPartitions3(d,arr));

    }

    //tabvul
    static int findways(int []nums,int tar){
        int n=nums.length;
        int dp[][]=new
                int[n][tar+1];
        if(nums[0]==0) dp[0][0]=2;//2 cases pick and not pick
        else
            dp[0][0]=1;//1 case not pick

        if(nums[0]!=0&&nums[0]<=tar) dp[0][nums[0]]=1;
        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=tar; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(nums[ind]<=target)
                    taken = dp[ind-1][target-nums[ind]];

                dp[ind][target]= (notTaken + taken)%mod;
            }
        }
        return dp[n-1][tar];

    }
    static int countPartitions2(int d,int []arr){
        int n=arr.length;
        int totSum = 0;
        for(int i=0; i<n;i++){
            totSum += arr[i];
        }
        if(totSum-d <0 || (totSum-d)%2==1 ) return 0;
        return findways(arr,(totSum-d)/2);
    }

    //space opt
    static int findways3(int[]num,int tar){
        int n=num.length;
        int prev[]=new int[tar+1];

        if(num[0]==0) prev[0]=2;//2 cases pick not pick
        else prev[0]=1; //one case not pick

        if(num[0]!=0&&num[0]<=tar) prev[num[0]]=1;//1 case pick

        for(int ind = 1; ind<n; ind++){
            int cur[]=new int[tar+1];
            for(int target= 0; target<=tar; target++){
                int notTaken = prev[target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = prev[target-num[ind]];

                cur[target]= (notTaken + taken)%mod;
            }
            prev = cur;
        }
        return prev[tar];
    }
    static int countPartitions3( int d,int[] arr){
        int n=arr.length;
        int totSum = 0;
        for(int i=0; i<n;i++){
            totSum += arr[i];
        }

        //Checking for edge cases
        if(totSum-d <0 || (totSum-d)%2 ==1) return 0;

        return findways3(arr,(totSum-d)/2);
    }

}
