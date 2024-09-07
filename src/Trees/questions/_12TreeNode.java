package Trees.questions;

public class _12TreeNode {//Maximum depth of binary tree
    int val;
    _12TreeNode left;
    _12TreeNode right;
    _12TreeNode(){}
    _12TreeNode(int val){
        this.val=val;
    }
    _12TreeNode(int val,_12TreeNode left,_12TreeNode right){
        this.val=val;
        this.left=right;
        this.right=right;
    }
    public int maxDepth(_12TreeNode root){
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        int depth=Math.max(left,right)+1;
        return depth;
    }
}
