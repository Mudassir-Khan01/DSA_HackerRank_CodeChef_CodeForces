package Trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _7MaxXorQueries {
     class Node{
        Node[] links=new Node[2];

        boolean containsKey(int ind){
            return (links[ind]!=null);
        }
        Node get(int bit){
            return links[bit];
        }
        void put(int ind, Node node){
            links[ind]=node;
        }

    };

     private static Node root;
     _7MaxXorQueries() {
         root = new Node();
     }

     //Insert a word into the trie
    public  void insert(int num){
         Node node=root;
         for(int i=31;i>=0;i--){
             int bit=(num>>i)&1;
             if(!node.containsKey(bit)){
                 node.put(bit, new Node());

             }
             node=node.get(bit);
         }
    }

    public int getMax(int num){
         Node node=root;
         int maxNum=0;
         for(int i=31;i>=0;i--){
             int bit=(num>>i)&1;
             if(node.containsKey(1-bit)){
                 maxNum=maxNum|(1<<i);
                 node=node.get(1-bit);
             }
             else {
                 node=node.get(bit);
             }
         }
         return maxNum;
    }

    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries){
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> offlineQueries=new ArrayList<ArrayList<Integer>>();
        int m=queries.size();
        for(int i=0;i<m;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(queries.get(i).get(1));//ai
            temp.add(queries.get(i).get(0));//xi
            temp.add(i);//query or index no.
            offlineQueries.add(temp);
        }
        Collections.sort(offlineQueries, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                return a.get(0).compareTo(b.get(0));
            }
        });
        int ind=0;
        int n=arr.size();
        _7MaxXorQueries trie=new _7MaxXorQueries();
        ArrayList<Integer> ans=new ArrayList<>(m);
        for(int i=0;i<m;i++){
            ans.add(-1);
        }
        for(int i=0;i<m;i++){
            while (ind<n&&arr.get(ind)<=offlineQueries.get(i).get(0)){//comparing with get(0) coz we stored the ai  at the 0th index
                trie.insert(arr.get(ind));
                ind++;
            }
            int queryInd=offlineQueries.get(i).get(2);
            if(ind!=0){
                ans.set(queryInd,trie.getMax(offlineQueries.get(i).get(1)));
            }
            else
                ans.set(queryInd,-1);
        }
        return ans;
    }
}
