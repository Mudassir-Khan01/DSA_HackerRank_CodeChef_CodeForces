package Trie;

import java.util.ArrayList;

public class _5MaximumXor {
    Node root;
    _5MaximumXor(){
        root=new Node();
    }
    void insert(int num){
        Node node=root;

        for(int i=31;i>=0;i--){
            int bit=(num>>i)&1;// Extract the i-th bit of the number
            if(!node.containsKey(bit)){
                //if the current node doesnt have a child node with the current bit
                node.put(bit,new Node());
            }
            //move to the corresponding node
            node=node.get(bit);
        }
    }

    int getMax(int num){
        Node node=root;
        //start from the root node
        int maxNum=0;
        //iterate through each bit of the number from left to right
        for(int i=31;i>=0;i--){
            //extract the ith bit of the number
            int bit=(num>>i)&1;
            //if the complement of the current bit exists or not
            if(node.containsKey(1-bit)){
                //update the maximum XOR value with the current bit
                maxNum=maxNum|(1<<i);
                //move to the corresponding bit
                node=node.get(1-bit);
            }else {
                node=node.get(bit);
            }
        }
        return maxNum;

    }

    static int maxXOR(int n, int m, ArrayList<Integer> arr1,ArrayList<Integer>arr2){
        //ctreate a tree object
        _5MaximumXor trie=new _5MaximumXor();
        //insert each number from the first set into the trie
        for (int it:arr1){
            trie.insert(it);
        }
        //intialize the maximum XOR value
        int maxi=0;
        for(int it:arr2){
            maxi=Math.max(maxi,trie.getMax(it));
        }
        return maxi;
    }

    static void printArr(ArrayList<Integer>arr){
        for(int it:arr){
            System.out.println(it+"");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>(java.util.Arrays.asList(3, 10, 5, 25, 2));
        ArrayList<Integer> arr2 = new ArrayList<>(java.util.Arrays.asList(8, 1, 2, 12, 7));
        int n = arr1.size();
        int m = arr2.size();

        System.out.print("Arr1: ");
        printArr(arr1);
        System.out.print("Arr2: ");
        printArr(arr2);

        int result = maxXOR(n, m, arr1, arr2);
        System.out.println("Maximum XOR value: " + result);
    }


    class Node{
        Node[] links=new Node[2];
        // Method to check if a specific
        // bit key is present in the child nodes
        boolean containsKey(int bit) {
            // Returns true if the link at
            // index 'bit' is not null
            return links[bit] != null;
        }

        // Method to get the child node
        // corresponding to a specific bit
        Node get(int bit) {
            // Returns the child
            // node at index 'bit'
            return links[bit];
        }

        // Method to set a child node at a
        // specific index in the links array
        void put(int bit, Node node) {
            // Sets the child node at index
            // 'bit' to the provided node
            links[bit] = node;
        }
    }
}

