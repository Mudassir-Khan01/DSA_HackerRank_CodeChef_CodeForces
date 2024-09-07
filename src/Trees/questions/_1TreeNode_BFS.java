package Trees.questions;

import java.util.*;

public class _1TreeNode_BFS {
    int val;
    _1TreeNode_BFS left;
    _1TreeNode_BFS right;

    _1TreeNode_BFS() {
    }

    _1TreeNode_BFS(int val) {
        this.val = val;
    }

    _1TreeNode_BFS(int val, _1TreeNode_BFS left, _1TreeNode_BFS right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<List<Integer>> levelOrder(_1TreeNode_BFS root){
        List<List<Integer>> result =new ArrayList<>();//create list  of list
        if(root==null){
            return result;
        }
        Queue<_1TreeNode_BFS> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsize=queue.size();
            List<Integer> currentlevel =new ArrayList<>(levelsize);//this list for one particular level
            for(int i=0;i<levelsize;i++){
                _1TreeNode_BFS currentNode=queue.poll();//remove and retrieve the head of the queue
                currentlevel.add(currentNode.val);
                if(currentNode.left!=null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentlevel);
        }
        return result;
    }
}


