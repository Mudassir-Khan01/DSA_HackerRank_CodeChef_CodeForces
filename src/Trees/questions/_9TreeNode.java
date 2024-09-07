package Trees.questions;

import java.util.LinkedList;
import java.util.Queue;

public class _9TreeNode {//Symmetric tree
    int val;
    _9TreeNode left;
    _9TreeNode right;
    _9TreeNode(){}
    _9TreeNode(int val){
        this.val=val;
    }
    _9TreeNode(int val,_9TreeNode left,_9TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }

    public boolean isSysmmetric(_9TreeNode root){
        Queue<_9TreeNode> queue=new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty()){
            _9TreeNode left=queue.poll();
            _9TreeNode right =queue.poll();
            if(left==null&&right==null){
                continue;
            }
            if(left==null||right==null){
                return false;
            }
            if(left.val!=right.val){
                return false;
            }
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
}
