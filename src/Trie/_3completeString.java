package Trie;

public class _3completeString {


        static class Node{
            Node[]links=new Node[26];
            boolean flag=false;
            public Node(){

            }
            boolean containskey(char ch){
                return links[ch-'a']!=null;
            }

            Node get(char ch){
                return links[ch-'a'];
            }

            void put(char ch, Node node){
                links[ch-'a']=node;
            }
            void setEnd(){
                flag=true;
            }
            boolean isEnd(){
                return flag;
            }
        }

        private static Node root;

    _3completeString(){
            root=new Node();
        }
        public static void insert(String word){
            Node node=root;
            for(int i=0;i<word.length();i++){
                if(!node.containskey(word.charAt(i))){
                    node.put(word.charAt(i),new Node());
                }
                node=node.get(word.charAt(i));
            }
            node.setEnd();
        }

        boolean checkIfPrefixExists(String word){
            Node node=root;

            boolean flag=true;
            for(int i=0;i<word.length();i++){
                if(node.containskey(word.charAt(i))){
                    node=node.get(word.charAt(i));
                    flag=flag & node.isEnd();
                    //or we can use if(node.isEnd()==false) return false and at the end return true;
                }else{
                    return false;
                }
            }
            return flag;
        }

        public static String completeString(int n, String[] a) {
            _3completeString obj=new _3completeString();
            for(int i=0;i<n;i++){
                obj.insert(a[i]);
            }
            String longest="";
            for(int i=0;i<n;i++){
                if(obj.checkIfPrefixExists(a[i])){
                    if(a[i].length()>longest.length()){
                        longest=a[i];
                    }else if(a[i].length()==longest.length()&&a[i].compareTo(longest)<0){
                        longest=a[i];
                    }
                }
            }
            if(longest=="") return "None";
            return longest;
        }

    public static void main(String[] args) {
    }
    }

