package Trees.questions;

public class _17TreeNode {//kth smallest element in bst
    int val;
    _17TreeNode left;
    _17TreeNode right;
    _17TreeNode(){}
    _17TreeNode(int val){
        this.val=val;
    }
    int count=0;
    public int kthsmallest(_17TreeNode root,int k){
        return helper(root,k).val;
    }
    public _17TreeNode helper(_17TreeNode root,int k){
        if(root==null){
            return null;
        }
        _17TreeNode left=helper(root.left,k);
        if(left!=null){
            return left;
        }
        count++;
        if(count==k){
            return root;
        }
        return helper(root.right,k);
    }
}
