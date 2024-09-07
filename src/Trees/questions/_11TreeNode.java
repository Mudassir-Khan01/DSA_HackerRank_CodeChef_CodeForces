package Trees.questions;

public class _11TreeNode {//Invert Binary Tree
    int val;
    _11TreeNode left;
    _11TreeNode right;
    _11TreeNode(){}
    _11TreeNode(int val){
        this.val=val;
    }
    _11TreeNode(int val,_11TreeNode left,_11TreeNode right){
        this.val=val;
        this.left=right;
        this.right=right;
    }
     public _11TreeNode invertnode(_11TreeNode root){
        if(root==null){
            return null;
        }
        _11TreeNode left=invertnode(root.left);
        _11TreeNode right=invertnode(root.right);
        root.left=right;
        root.right=left;
        return root;
     }
}
