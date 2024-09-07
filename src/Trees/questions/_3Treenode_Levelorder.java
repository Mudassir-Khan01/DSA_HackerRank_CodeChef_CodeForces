package Trees.questions;

import java.util.LinkedList;
import java.util.Queue;

public class _3Treenode_Levelorder {
    int val;
    _3Treenode_Levelorder left;
    _3Treenode_Levelorder right;
    _3Treenode_Levelorder(){
    }
    _3Treenode_Levelorder(int val){
        this.val=val;
    }
    _3Treenode_Levelorder(int val,_3Treenode_Levelorder left,_3Treenode_Levelorder right){
        this.val=val;
        this.right=right;
        this.left=left;
    }

    public _3Treenode_Levelorder findsuccessor(_3Treenode_Levelorder root,int key) {
        if (root == null) {
            return null;
        }
        Queue<_3Treenode_Levelorder> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelsize = queue.size();
            _3Treenode_Levelorder currentNode = queue.poll();//remove and retrieve the head of the queue
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
            if (currentNode.val == key) {
                break;
            }
        }
        return queue.peek();
    }

}
