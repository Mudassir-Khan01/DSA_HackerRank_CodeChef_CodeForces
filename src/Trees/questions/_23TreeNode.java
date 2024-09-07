package Trees.questions;

public class _23TreeNode {
    int val;
    _23TreeNode left;
    _23TreeNode right;
    _23TreeNode (){}
    _23TreeNode(int val){
        this.val=val;
    }
    boolean findpath(_23TreeNode node,int[]arr){
        if(node==null){
            return arr.length==0;
        }
        return helper(node,arr,0);
    }
    boolean helper(_23TreeNode node,int[]arr,int index){
     if(node==null){
         return false;
     }
     if(index>=arr.length||node.val!=arr[index]){
         return false;
     }
     if(node.left==null&&node.right==null ){;//&& index=arr.length-1
         return true;
     }
     return helper(node.left,arr,index+1)||helper(node.right,arr,index+1);
    }
}
