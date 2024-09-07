package Trees.questions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _19TreeNode {
    int val;
    _19TreeNode left;
    _19TreeNode right;
    _19TreeNode (){}
    _19TreeNode(int val){
        this.val=val;
    }
    public List<String> serialize(_19TreeNode node){
     List<String>list=new ArrayList<>();
     helper(node,list);
     return list;
    }
    void helper(_19TreeNode node,List<String> list){
    if(node==null){
        list.add("null");
        return;
    }
    list.add(String.valueOf(node.val));
    helper(node.left,list);
    helper(node.right,list);
    }

    _19TreeNode deserialize(List<String> list){
        Collections.reverse(list);
        _19TreeNode node=helper2(list);
        return node;
    }
    _19TreeNode helper2(List<String>list){
        String val=list.remove(list.size()-1);
        if(val.charAt(0)=='n'){
            return null;
        }
        _19TreeNode node=new _19TreeNode(Integer.parseInt(val));
        node.left=helper2(list);
        node.right=helper2(list);
        return node;
    }
}
