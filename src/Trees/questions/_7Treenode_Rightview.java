package Trees.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _7Treenode_Rightview {
    int val;
    _7Treenode_Rightview left;
    _7Treenode_Rightview right;

    _7Treenode_Rightview() {
    }

    _7Treenode_Rightview(int val) {
        this.val = val;
    }

    _7Treenode_Rightview(int val, _7Treenode_Rightview left, _7Treenode_Rightview right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<Integer> rightSideview(_7Treenode_Rightview root){
        List<Integer> result =new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<_7Treenode_Rightview> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsize=queue.size();
            for(int i=0;i<levelsize;i++){
                _7Treenode_Rightview currentNode=queue.poll();
                if(i==levelsize-1){
                    result.add(currentNode.val);    
                }
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
}
