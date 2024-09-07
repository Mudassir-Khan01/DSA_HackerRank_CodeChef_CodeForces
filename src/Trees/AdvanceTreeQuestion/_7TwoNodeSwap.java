package Trees.AdvanceTreeQuestion;


public class _7TwoNodeSwap {
  Node first;
  Node second;
  Node prev;
  public void helper(Node root){
      iot(root);//in order traversal

      //swap
      int temp=first.val;
      first.val=second.val;
      second.val=temp;
  }
  private void iot(Node node){
      if(node==null){
          return;
      }
      iot(node.left);
      if(prev!=null&&prev.val>node.val){
          if(first==null){
              first=prev;//found first misplaced node
          }
          second=prev;//if first isnt null
      }
      prev=node;//if everything is fine then assign it normally
  }

}
class Node {
    int val;
    Node left;
    Node right;
    public Node(int val) {
        this.val = val;
    }
}
