package Trees.AdvanceTreeQuestion;
import java.util.*;
public class _2TreeNode {//Vertical Order Traversal
    int val;
     _2TreeNode left;
     _2TreeNode right;
      _2TreeNode() {}
     _2TreeNode(int val) { this.val = val; }
     _2TreeNode(int val, _2TreeNode left, _2TreeNode right) {
          this.val = val;
         this.left = left;
         this.right = right;
     }
    public List<List<Integer>> verticalTraversal(_2TreeNode node) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(node==null){
            return ans;
        }
        int col=0;
        Queue<Map.Entry<_2TreeNode,Integer>> queue=new ArrayDeque<>();//creating queue and storing node along with its index
        Map<Integer,ArrayList<Integer>>map=new HashMap<>();//creating hashmap for storing col and its corresponding list of nodes
        queue.offer(new AbstractMap.SimpleEntry<>(node,col));
        int min=0, max=0;//initial
        while (!queue.isEmpty()){
            Map.Entry<_2TreeNode,Integer>removed=queue.poll();//entry karao removed mein from the queue which contains node and its corresponding col
            node=removed.getKey();
            col=removed.getValue();
            if(node!=null){
                if(!map.containsKey(col)){
                    map.put(col,new ArrayList<>());//entry in hashmap
                }
                map.get(col).add(node.val);//get the col and put node's value
                min=Math.min(min,col);
                max=Math.max(max,col);
                queue.offer(new AbstractMap.SimpleEntry<>(node.left,col-1));
                queue.offer(new AbstractMap.SimpleEntry<>(node,col+1));
            }
        }
        for (int i=min;i<=max;i++){
            ans.add(map.get(i));
        }
        return ans;
    }
}
