package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class _34MinMultiplication {
    public int minimumMultiplications(int[]arr,int start,int end){
        Queue<Pairr> q=new LinkedList<>();
        q.add(new Pairr(start,0));
        int dist[]=new int[100000];
        for(int i=0;i<100000;i++){
            dist[i]=(int)1e9;
        }
        dist[start]=0;
        int n=arr.length;
        int mod=100000;
        //multiply the start no. with each of the numbers in the array
        //until we get the end no.
        while (!q.isEmpty()){
            int node=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            for(int i=0;i<n;i++){
                int num=(arr[i]*node)%mod;
                //if the no. of the multipliction are less than before
                //in order to reach a number we update the dist array
                if(steps+1<dist[num]){//agar steps +1 kam hai distance of adjacent node se
                    dist[num]=steps+1;
                    if(num ==end){
                        return steps+1;
                    }
                    q.add(new Pairr(num,steps+1));
                }
            }
        }
        //if the end no. is unreachable
        return -1;
    }
    public static void main(String[] args) {

        int start=3, end=30;
        int[] arr = {2,5,7};

        _34MinMultiplication obj = new _34MinMultiplication();
        int ans = obj.minimumMultiplications(arr,start,end);

        System.out.print(ans);
        System.out.println();
    }
}
