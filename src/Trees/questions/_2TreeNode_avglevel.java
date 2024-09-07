package Trees.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

    public class _2TreeNode_avglevel{
        int val;
        _2TreeNode_avglevel left;
        _2TreeNode_avglevel right;

        _2TreeNode_avglevel() {
        }

        _2TreeNode_avglevel(int val) {
            this.val = val;
        }

        _2TreeNode_avglevel(int val, _2TreeNode_avglevel left, _2TreeNode_avglevel right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public List<Double> levelOrder(_2TreeNode_avglevel root){
            List<Double> result =new ArrayList<>();
            if(root==null){
                return result;
            }
            Queue<_2TreeNode_avglevel> queue=new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int levelsize=queue.size();
                double averagelevel=0;//we dont need to store level just calculate it
                for(int i=0;i<levelsize;i++){
                    _2TreeNode_avglevel currentNode=queue.poll();//remove and retrieve the head of the queue
                    averagelevel+=currentNode.val;//this is sum of all the levels
                    if(currentNode.left!=null){
                        queue.offer(currentNode.left);
                    }
                    if(currentNode.right!=null){
                        queue.offer(currentNode.right);
                    }
                }
                averagelevel=averagelevel/levelsize;
                result.add(averagelevel);
            }
            return result;
        }

    }
