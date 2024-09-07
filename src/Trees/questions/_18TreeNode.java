package Trees.questions;

import java.util.Arrays;

public class _18TreeNode {
    int val;
    _18TreeNode left;
    _18TreeNode right;
    _18TreeNode(){}
    _18TreeNode(int val){
        this.val=val;
    }
    public _18TreeNode buildTree(int[] preorder,int [] inorder){
      if(preorder.length==0){
          return null;
      }
      int r=preorder[0];
      int index=0;
      for(int i=0;i<inorder.length;i++){
          if(inorder[i]==r){
              index=i;
          }
      }
      _18TreeNode node=new _18TreeNode(r);
      node.left=buildTree(Arrays.copyOfRange(preorder,1,index+1),Arrays.copyOfRange(inorder,0,index));
        node.right=buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length),Arrays.copyOfRange(inorder,index+1,inorder.length));
return node;
    }

}
