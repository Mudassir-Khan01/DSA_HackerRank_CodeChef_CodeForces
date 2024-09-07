package Trees.AdvanceTreeQuestion;

import java.util.*;
public class _5TreeNode {//kth smallest  element
    int val;
    _5TreeNode left;
    _5TreeNode right;
    _5TreeNode() {}
    _5TreeNode(int val) { this.val = val; }
    _5TreeNode(int val, _5TreeNode left, _5TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public int kthsmallest(_5TreeNode root,int k){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
         helper(root,minHeap,k);
         int ans=0;
         for(int i=0;i<k;i++){//for removing kth element
              ans=minHeap.poll();
         }
         return ans;
    }
    private void helper(_5TreeNode node,PriorityQueue<Integer> minHeap,int k){
    if(node==null){
        return;
    }
    helper(node.left,minHeap,k);//inorder travesal so left part first
    minHeap.offer(node.val);
    helper(node.right,minHeap,k);
    }

    //another way of doing it More efficient
    private int k;//globally
    private int ans;
    public int  kthSmallest(_5TreeNode root,int k){
        this.k=k;
        helper2(root);
        return ans;
    }
    private void helper2(_5TreeNode node){
        if(node==null){
            return;
        }
        helper2(node.left);//just do inorder
        k--;//just start from leftmost and decrease it by 1 when k ==0 means kth samllest element found return it
        if(k==0){
            ans=node.val;
            return;
        }
        helper2(node.right);
    }
}
