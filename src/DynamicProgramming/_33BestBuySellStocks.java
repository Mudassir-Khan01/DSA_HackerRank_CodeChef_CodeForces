package DynamicProgramming;

public class _33BestBuySellStocks {
    static int maximumProfit(int []arr){
        int maxprofit=0;
        int mini=arr[0];
        for(int i=1;i<arr.length;i++){
            int curprofit=arr[i]-mini;
            maxprofit=Math.max(maxprofit,curprofit);
            mini=Math.min(mini,arr[i]);
        }
        return maxprofit;
    }
    public static void main(String args[]) {

        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maximumProfit(Arr));
    }
}
