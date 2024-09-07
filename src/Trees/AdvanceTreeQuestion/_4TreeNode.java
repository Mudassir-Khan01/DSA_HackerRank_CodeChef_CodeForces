package Trees.AdvanceTreeQuestion;
import java.util.*;
public class _4TreeNode {//two sum IV
    int val;
    _4TreeNode left;
    _4TreeNode right;
    _4TreeNode() {}
    _4TreeNode(int val) { this.val = val; }
    _4TreeNode(int val, _4TreeNode left, _4TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
      public boolean findTarget(_4TreeNode root,int k){
        HashSet<Integer> set=new HashSet<>();
        return helper(root,k,set);
      }
      private boolean helper(_4TreeNode node,int k,HashSet<Integer>set){
        if(node==null){
            return false;
        }
        if(set.contains(k-node.val)){
            return true;
        }
        set.add(node.val);
        return helper(node.left,k,set)||helper(node.right,k,set);
      }
}
