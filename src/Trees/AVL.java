package Trees;

public class AVL {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int  height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
    private Node root;
    public AVL() {
    }
    public int height(){
        return height(root);
    }
    public int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public void insert(int value){
        root=insert(value,root);
    }
    private Node insert(int value, Node node){
        if(node==null){
            node=new Node( value);//create a node and then return it
            return node;
        }
        if(value<node.value){
            node.left=insert(value,node.left);
        }
        if(value>node.value){
            node.right=insert(value,node.right);
        }
        node.height =Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }
    private Node rotate(Node node){
        if(height(node.left)-height(node.right)>1){//left wala 2 cases
            if(height(node.left.left)-height(node.left.right)>0){//left-left case
               return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){//left-right case
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }
        if(height(node.left)-height(node.right)<-1){//right wala 2 cases
            if(height(node.right.left)-height(node.right.right)<0){//right-right case
                return leftRotate(node);
            }
            if(height(node.right.left)-height(node.right.right)>0){//right-left case
                node.right=rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }
    public  Node rightRotate(Node p){
       Node c=p.left;
       Node t=c.right;

       c.right=p;
       p.left=t;
       p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return c;
    }
    public  Node leftRotate(Node c){
        Node p=c.right;
        Node t=p.left;

        p.left=c;
        c.right=t;
        p.height=Math.max(height(p.left),height(p.right)+1);
        c.height=Math.max(height(c.left),height(c.right)+1);
        return p;
    }


    public void populate (int[]nums){
        for(int i=0;i<nums.length;i++){
            this.insert(nums[i]);
        }
    }

    public boolean balanced(){
        return balanced(root);
    }
    private boolean balanced(Node node){//whether it isn balanced or not
        if(node==null){
            return true;
        }
        return Math.abs(height(node.left)-height(node.right))<=1&&balanced(node.left)&&balanced(node.right);//check sepearte for the left as well as for the right
    }
    public void display(){
        display(this.root,"Root node :");
    }
    private void display(Node node, String details){
        if(node==null){
            return;
        }
        System.out.println(details+node.value);
        display(node.left,"Left child of"+node.value+":");
        display(node.right,"right child of"+node.value+":");
    }

    //for sorted
    public void populatesorted(int[]nums){
        populatesorted(nums,0,nums.length);
    }
    private void populatesorted(int[]nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        this.insert(nums[mid]);
        populatesorted(nums,0,mid);
        populatesorted(nums,mid+1,end);
    }

    public static void main(String[] args) {
        AVL tree=new AVL();
        for(int i=0;i<1000;i++){
            tree.insert(i);
        }
        System.out.println(tree.height());
    }
}
