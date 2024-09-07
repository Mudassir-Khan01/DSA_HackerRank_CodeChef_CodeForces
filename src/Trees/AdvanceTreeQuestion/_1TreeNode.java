package Trees.AdvanceTreeQuestion;

import Trees.questions._17TreeNode;
import Trees.questions._1TreeNode_BFS;

import java.util.HashMap;

class _1TreeNode {//PreIn
    int val;
    _1TreeNode left;
    _1TreeNode right;
    public _1TreeNode(){}
    public _1TreeNode(int val){
        this.val=val;
    }
    public _1TreeNode(int val,_1TreeNode left,_1TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;

    }
    public _1TreeNode buildTree(int[] preOrder, int[] inOrder) {
        HashMap<Integer, Integer> map = new HashMap<>();//for value and its index
        for (int i = 0; i < inOrder.length; i++) {
            map.put(inOrder[i], i);
        }
        int[] index = {0};//for getting elements in preorder one by one
        return helper(preOrder, inOrder, 0, preOrder.length, map, index);
    }

    public _1TreeNode helper(int[]preOrder,int[]inOrder,int left,int right,HashMap<Integer,Integer>map,int[]index){
     if(left>right){
         return null;
     }
     int current=preOrder[index[0]];
     index[0]++;
        _1TreeNode node=new _1TreeNode(current);
        if(left==right){
            return node;
        }
        int inorderindex=map.get(current);//to get that index
        node.left=helper(preOrder,inOrder,left,inorderindex-1,map,index);
        node.left=helper(preOrder,inOrder,inorderindex+1,right,map,index);
        return node;
    }
}
