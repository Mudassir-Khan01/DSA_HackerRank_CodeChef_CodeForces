package Trees.questions;

import java.util.Stack;

public class _24DFSstack {
    int val;
    _24DFSstack left;
    _24DFSstack right;
    _24DFSstack(){}
    _24DFSstack(int val){
        this.val=val;
    }
    void dfsStack(_24DFSstack node){
        if(node==null){
            return;
        }
        Stack<_24DFSstack>stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            _24DFSstack removed=stack.pop();
            System.out.println(removed.val+"");
            if(removed.right!=null){//push right first as it is pre order travesral
                stack.push(removed.right);
            }
            if(removed.left!=null){
                stack.push(removed.left);
            }
        }
    }
}
