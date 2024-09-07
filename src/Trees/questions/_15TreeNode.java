package Trees.questions;

public class _15TreeNode {
    int val;
    _15TreeNode left;
    _15TreeNode right;
    _15TreeNode(){}
    _15TreeNode(int val){
        this.val=val;
    }
    _15TreeNode(int val,_15TreeNode left,_15TreeNode right){
        this.val=val;
        this.left=right;
        this.right=right;
    }
    public boolean isValidBST(_15TreeNode root){
        return helper(root,null,null);
    }
    public boolean helper(_15TreeNode node,Integer low,Integer high){
        if(node==null){
            return true;
        }
        if(low!=null && node.val<=low){
            return false;
        }
        if(high!=null&&node.val>=high){
            return false;
        }
        boolean lefttree=helper(node.left,low,node.val);
        boolean righttree=helper(node.right,node.val,high);
      return lefttree&&righttree;//both should be true
    }
}
