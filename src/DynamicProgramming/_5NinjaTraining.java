package DynamicProgramming;

import java.util.Arrays;

public class _5NinjaTraining {
    //Memoization
    static int f(int day,int last,int[][]points,int[][]dp){
        if(dp[day][last]!=-1) return dp[day][last];//if result is already calc return it

        if(day==0){
            int maxi=0;
            for(int i=0;i<=2;i++){//3 activity
                if(i!=last)//different activity
                    maxi=Math.max(maxi,points[0][i]);
            }
            return dp[day][last]=maxi;//store and return the result
        }
        int maxi=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                //calculate the points for the current activity and recursively
                //calculate the maxm points for the previous day
                int activity=points[day][i]+f(day-1,i,points,dp);
                maxi=Math.max(maxi,activity);//update the maximum points
            }
        }
        return dp[day][last]=maxi;
    }
    //memoization part
    static int ninjaTraining(int n,int[][]points){
        int dp[][]=new int[n][4];
        for (int[]row:dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,3,points,dp);
    }
    public static void main(String args[]) {
        // Define the points for each activity on each day
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        int n = points.length; // Get the number of days
        System.out.println(ninjaTraining(n, points)); // Calculate and print the maximum points

        //for tabukation
        System.out.println(ninjaTaining2(n, points));

        //for space  optimization
        System.out.println(ninjaTraining3(n, points));


    }

    //Tabulation
    static int ninjaTaining2(int n,int [][]points){
  int [][]dp=new int[n][4];
        //base conditions
        dp[0][0]=Math.max(points[0][1],points[0][2]);
        dp[0][1]=Math.max(points[0][0],points[0][2]);
        dp[0][2]=Math.max(points[0][1],points[0][0]);
        dp[0][3]=Math.max(points[0][1],Math.max(points[0][2],points[0][0]));

        //iterate through each day and eachg activity
        for(int day=1;day<n;day++){
            for (int last=0;last<4;last++){
                dp[day][last]=0;//itialize the maximimum points of current and last activuty
                //consider each possible task for the current day
                for(int task=0;task<=2;task++){
                    if(task!=last){//ensure curreent task is different from the last task
                        //calc the points for the current task and add it to the maximum points from the previous task
                        int activity=points[day][task]+dp[day-1][task];
                        //update the maximum points for the current day and last activity
                        dp[day][last]=Math.max(dp[day][last],activity);
                    }
                }
            }
        }
        return dp[n-1][3];
    }

    //Sapce Optimization
    static int ninjaTraining3(int n,int [][]points){
        int prev[]=new int[4];//to store maxm points for the prev day
        //initalize it
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        //iterate through each day  starting from second day
        for(int day=1;day<n;day++ ){
            //initalize temp to store maximum points for the current day
            int current[]=new int[4];
            for(int last=0;last<4;last++){
                current[last]=0;//itialize maximum point for the current day and the last activity
                for (int task=0;task<=2;task++){
                    if(task!=last){//ensure current task is different from the last task
                      //calculate the points for the current activity
                        //and add it to the maxm point from the previous day
                        int activity=points[day][task]+prev[task];
                       current[last]=Math.max(current[last],activity);
                    }
                }
            }
            prev=current;
        }
        return prev[3];
    }
}
