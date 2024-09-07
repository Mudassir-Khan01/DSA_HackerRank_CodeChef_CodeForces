package Trees.questions;

public class _16TreeNode {//lowest common ancestor
     int val;
     _16TreeNode left;
     _16TreeNode right;
     _16TreeNode(int x){
          val=x;
     }
     public _16TreeNode lowestCommon(_16TreeNode root,_16TreeNode p,_16TreeNode q){
     if(root==null){
         return null;
     }
     if(root==p||root==q){
          return root;
     }
     _16TreeNode left=lowestCommon(root.left,p,q);
     _16TreeNode right=lowestCommon(root.right,p,q);
     if(left!=null&&right!=null){
          return root;
     }
     return left==null?right:left;//if left is null return right otherwise return left
     }
}
