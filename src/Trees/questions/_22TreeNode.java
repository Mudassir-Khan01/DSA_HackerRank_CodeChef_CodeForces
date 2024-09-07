package Trees.questions;

public class _22TreeNode {
    int val;
    _22TreeNode left;
    _22TreeNode right;
    _22TreeNode (){}
    _22TreeNode(int val){
        this.val=val;
    }
    _22TreeNode(int val,_22TreeNode left,_22TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(_22TreeNode root){
        helper(root);
        return ans;
    }
    int helper(_22TreeNode node){
        if(node==null){
            return 0;
        }
        int left=helper(node.left);
        int right =helper(node.right);
        left=Math.max(0,left);//if negative then dont take it or just take 0 instead of -ve
        right=Math.max(0,right);
        int pathsum=left+right+node.val;
        ans=Math.max(ans,pathsum);
        return Math.max(left,right)+node.val;
    }
}
