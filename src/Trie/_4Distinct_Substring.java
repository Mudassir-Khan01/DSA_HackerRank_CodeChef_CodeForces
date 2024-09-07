package Trie;

public class _4Distinct_Substring {
    public static int countDistinctSubstrings(String s){
     Node root=new Node();
     int cnt=0;
     int n=s.length();
     for(int i=0;i<n;i++){
         //iterate through each starting position of the substring
         Node node=root;
         //start from the root for each substring
         for(int j=i;j<n;j++ ){
             //Iterate through each charater of the string
             //If the current character is not a child
             //of the current node insert it as a new child node
             if(!node.containskey(s.charAt(j))){
                 node.put(s.charAt(j),new Node());
                 cnt++;
             }
             //move ahead
             node=node.get(s.charAt(j));
         }
     }
     return cnt+1;//+1 to account for the input string itself
    }
    static class Node{
        Node[]links=new Node[26];
        boolean flag=false;
        public boolean containskey(char ch){
            return links[ch-'a']!=null;
        }

        public Node get(char ch){
            return links[ch-'a'];
        }
        public void put(char ch, Node node){
            links[ch-'a']=node;
        }
        public void setEnd(){
            flag=true;
        }
        public boolean isEnd(){
            return flag;
        }
    }

    public static void main(String[] args) {
        String s = "striver";
        // Input string
        System.out.println("Current String: " + s);
        System.out.println("Number of distinct substrings: " + countDistinctSubstrings(s));
        // Output the result
    }


}

