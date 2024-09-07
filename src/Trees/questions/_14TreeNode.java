package Trees.questions;

public class _14TreeNode {
    int val;
    _14TreeNode left;
    _14TreeNode right;
    _14TreeNode(){}
    _14TreeNode(int val){
        this.val=val;
    }
    _14TreeNode(int val,_14TreeNode left,_14TreeNode right){
        this.val=val;
        this.left=right;
        this.right=right;
    }

    public void flatten(_14TreeNode root){
        _14TreeNode current=root;
        while (current!=null){
            if(current.left!=null){
                _14TreeNode temp=current.left;
                while (temp.right!=null){
                    temp=temp.right;
                }
                temp.right=current.right;
                current.right=current.left;
                current.left=null;
            }
            current=current.right;
        }
    }
}
