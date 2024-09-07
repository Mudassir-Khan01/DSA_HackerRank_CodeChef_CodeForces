package Trees.questions;

public class _21TreeNode {
    int val;
    _21TreeNode left;
    _21TreeNode right;
    _21TreeNode (){}
    _21TreeNode(int val){
        this.val=val;
    }
    _21TreeNode(int val,_21TreeNode left,_21TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }
    public int sumNumbers(_21TreeNode root){
        return helper(root,0);
    }
    int helper(_21TreeNode node,int sum){
        if(node==null){
            return 0;
        }
        sum=sum*10+node.val;
        if(node.left==null&&node.right==right){
            return sum;
        }
        return helper(node.left,sum)+helper(node.right,sum);
    }
}
