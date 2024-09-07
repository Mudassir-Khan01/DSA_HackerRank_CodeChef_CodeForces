package Trees.questions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _4Treenode_zigzag {
    int val;
    _4Treenode_zigzag left;
    _4Treenode_zigzag right;

    _4Treenode_zigzag() {
    }

    _4Treenode_zigzag(int val) {
        this.val = val;
    }

    _4Treenode_zigzag(int val, _4Treenode_zigzag left, _4Treenode_zigzag right) {
        this.val = val;
        this.right = right;
        this.left = left;
    }
    public List<List<Integer>> zigzaglevelOrder(_4Treenode_zigzag root){
     List<List<Integer>> result=new ArrayList<>();
     if(root==null){
         return result;
     }
        Deque<_4Treenode_zigzag> queue =new LinkedList<>();
     queue.offer(root);
     boolean reverse=false;
     while(!queue.isEmpty()){
     int levelsize= queue.size();
     List<Integer> currentlevel=new ArrayList<>(levelsize);
     for(int i=0;i<levelsize;i++){
         if(!reverse){//if it is true normal order
         _4Treenode_zigzag currentnode=queue.pollFirst();
         currentlevel.add(currentnode.val);
         if(currentnode.left!=null){
             queue.addLast(currentnode.left);
         }
         if(currentnode.right!=null){
             queue.addLast(currentnode.right);
         }
         }else{//reverse order
         _4Treenode_zigzag currentnode=queue.pollLast();
         currentlevel.add(currentnode.val);
         if(currentnode.right!=null){//ye left k baad aana chahiye
                 queue.addFirst(currentnode.right);
             }
         if(currentnode.left!=null){
             queue.addFirst(currentnode.left);
         }

         }
         reverse=!reverse;//next level it will flip ek baar false toh next true
     }
     result.add(currentlevel);
     }
     return result;
    }
}
