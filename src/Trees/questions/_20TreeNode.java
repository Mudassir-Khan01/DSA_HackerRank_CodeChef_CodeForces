package Trees.questions;

public class _20TreeNode {//Path sum
    int val;
    _20TreeNode left;
    _20TreeNode right;
    _20TreeNode (){}
    _20TreeNode(int val){
        this.val=val;
    }
    _20TreeNode(int val,_20TreeNode left,_20TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
    public boolean hasPathSum(_20TreeNode root,int targetSum){
        if(root==null){
            return false;
        }
        if(root.val==targetSum&&root.left==null&&root.right==null){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
