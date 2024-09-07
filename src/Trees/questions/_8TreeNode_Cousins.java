package Trees.questions;

public class _8TreeNode_Cousins {
    int val;
    _8TreeNode_Cousins left;
    _8TreeNode_Cousins right;
    _8TreeNode_Cousins(){}
    _8TreeNode_Cousins(int val){
        this.val=val;
    }
    _8TreeNode_Cousins(int val,_8TreeNode_Cousins left,_8TreeNode_Cousins right){
        this.val=val;
        this.left=left;
        this.right=right;
    }

    public boolean isCousins(_8TreeNode_Cousins root,int x,int y){
      _8TreeNode_Cousins xx=findnode(root,x);
      _8TreeNode_Cousins yy=findnode(root,y);

      return (
              (level(root,xx,0)==level(root,yy,0))&&(!isSiblings(root,xx,yy))//should be at same level and no sibilings
              );
    }

    _8TreeNode_Cousins findnode(_8TreeNode_Cousins node,int x){
        if(node==null){
            return null;
        }
        if(node.val==x){
            return node;
        }
        _8TreeNode_Cousins n=findnode(node.left,x);
        if(n!=null){
            return n;
        }
        return findnode(node.right,x);
    }

    boolean isSiblings(_8TreeNode_Cousins node,_8TreeNode_Cousins x,_8TreeNode_Cousins y ){
        if(node==null){
            return false;
        }
        return (node.left==x&&node.right==y||node.left==y&&node.right==x||isSiblings(node.left,x,y)||isSiblings(node.right,x,y));
    }
    int level(_8TreeNode_Cousins node,_8TreeNode_Cousins x,int lev){
        if(node==null){
            return 0;
        }
        if(node==x){
            return lev+1;
        }
        int l=level(node.left,x,lev+1);
        if(l!=0){
            return l;
        }
        return level(node.right,x,lev+1);

    }
}
