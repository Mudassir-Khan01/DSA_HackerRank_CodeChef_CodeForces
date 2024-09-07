package Trees.questions;

import Trees.BT;

import java.util.Scanner;

//DEPTH FIRST SEARCH DFS
public class _10TreeNode {//Diameter of Binary tree
    int val;
    _10TreeNode left;
    _10TreeNode right;
    _10TreeNode(){}
    _10TreeNode(int val){
        this.val=val;
    }
    _10TreeNode(int val,_10TreeNode left,_10TreeNode right){
        this.val=val;
        this.left=left;
        this.right=right;
    }

    private _10TreeNode root;
    //insert element
    public void populate(Scanner sc){
        System.out.println("Enter the root node");
        int value=sc.nextInt();
        root=new _10TreeNode(value);
        populate(sc,root);
    }
    private void populate(Scanner sc, _10TreeNode node){
        System.out.println("do u want to enter left of"+node.val);
        boolean left=sc.nextBoolean();
        if(left){
            System.out.println("Enter the value of the left of"+node.val);
            int value =sc.nextInt();
            node.left=new _10TreeNode(value);
            populate(sc,node.left);
        }
        System.out.println("do u want to enter right of"+node.val);
        boolean right=sc.nextBoolean();
        if(right){
            System.out.println("Enter the value of the right of"+node.val);
            int value=sc.nextInt();
            node.right=new _10TreeNode(value);
            populate(sc,node.right);
        }
    }
    public void display(){
        display(root,"");
    }
    private void display(_10TreeNode node, String indent){
        if(node==null){
            return ;
        }
        System.out.println(indent+node.val);
        display(node.left,indent+"\t");
        display(node.right,indent+"\t");
    }

    public void diameterBT(){
        int d=diameterBT(root);
        System.out.println(d);
    }
    int diameter=0;
    public int diameterBT(_10TreeNode root){
        height(root);


        return diameter-1;
    }
    int height(_10TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHeight=height(node.left);
        int rightHeight=height(node.right);
        int dia=leftHeight+rightHeight+1;
        diameter=Math.max(diameter,dia);//just updating the diamter
        return Math.max(leftHeight,rightHeight)+1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        _10TreeNode tree=new _10TreeNode();
        tree.populate(sc);
        tree.display();
        tree.diameterBT();
    }
}
