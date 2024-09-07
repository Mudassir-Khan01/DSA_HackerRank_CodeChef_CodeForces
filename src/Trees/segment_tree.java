package Trees;

public class segment_tree {
    private static class Node {
        int data;
        int startInterval;
        int endEnterval;
        Node left;
        Node right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endEnterval = endInterval;
        }
    }

    Node root;

    public segment_tree(int[] arr) {
        //create a tree using this array
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    public Node constructTree(int[] arr, int start, int end) {
        if (start == end) {//leaf
            Node leaf = new Node(start, end);
            leaf.data = arr[start];
            return leaf;
        }
        //create new node with index you are at
        Node node=new Node(start,end);
        int mid=(start+end)/2;
        node.left=this.constructTree(arr,start,mid);
        node.right=this.constructTree(arr,mid+1,end);
        node.data=node.left.data+node.right.data;
        return node;
    }
    public void display(){
        display(this.root);
    }
    private void display(Node node){
        String str="";
        if(node.left!=null){
            str=str+"Interval=["+node.left.startInterval+"-"+node.left.endEnterval+"] and data"+node.left.data+"=>" ;
        }else{
            str=str+"No left child ";

        }
        //for current node
        str=str+"Interval=["+node.startInterval+"-"+node.endEnterval+"] and data"+node.data+"<=" ;

        if(node.right!=null){
            str=str+"Interval=["+node.right.startInterval+"-"+node.right.endEnterval+"] and data"+node.right.data+"=>" ;
        }else{
            str=str+"No right child ";

        }
        System.out.println(str);

        //call recursion
        if(node.left!=null){
            display(node.left);
        }
        if(node.right!=null){
            display(node.right);
        }
    }

    //query
    public int query(int qsi,int qei){
        return this.query(this.root,qsi,qei);
    }
    private int query(Node node,int qsi,int qei){
        if(node.startInterval>=qsi && node.endEnterval<=qei){
            //Completely lying inside query
            return node.data;
        }else if(node.startInterval>qei|| node.endEnterval<qsi){
            //completely outside
            return 0;
        }else{
            return this.query(node.left,qsi,qei)+this.query(node.right,qsi,qei);
        }
    }
    //update
    public void update(int index,int value){
        this.root.data=update(this.root,index,value);
    }
    public int update(Node node,int index, int value){
       if(index>=node.startInterval&&index<=node.endEnterval){
           if(index==node.startInterval&&index==node.endEnterval){
               node.data=value;
               return node.data;
           }else {
               int leftAns=update(node.left,index,value);
               int rightANs=update(node.right,index,value);
               node.data=leftAns+rightANs;
               return node.data;
           }
       }
       return node.data;
    }

    public static void main(String[] args) {
        int[]arr={3,8,6,7,-2,-8,4,9};
        segment_tree trr=new segment_tree(arr);
        trr.display();
    }
}
