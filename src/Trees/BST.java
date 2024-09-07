package Trees;

public class BST {
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
    public BST() {
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
        return node;
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
        private void display(Node node,String details){
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

    //Pre order traversal
    public void preorder(){
        preorder(root);
    }
    private void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.value+"");
        preorder(node.left);
        preorder(node.right);
    }

    //inorder traversal
    public void inorder(){
        inorder(root);
    }
    private void inorder(Node node){
        if(node==null){
            return;
        }
        preorder(node.left);
        System.out.println(node.value+"");
        preorder(node.right);
    }
    //postorder traversal
    public void postorder(){
        postorder(root);
    }
    private void postorder(Node node){
        if(node==null){
            return;
        }
        preorder(node.left);
        preorder(node.right);
        System.out.println(node.value+"");
    }


    public static void main(String[] args) {
BST tree=new BST();
int []nums={5,2,3,32,2,3,3,2};
tree.populate(nums);
tree.display();
tree.preorder();
    }
    }
