package Trie;

import java.sql.Struct;

public class Trie1 {
    //Node structure for Trie
    static class Node{
        //Array to store links to child nodes, each index represents a letter
        Node[] links=new Node[26];
        // flag indicating if the node marks the end of a word
        boolean flag = false;
        //check if the node contains
        //a specific key (letter)

        boolean containKey(char ch){
            return links[ch-'a']!=null;
        }

        void put(char ch, Node node){
            links[ch-'a']=node;
        }
        Node get(char ch){
            return links[ch-'a'];
        }
        void setEnd(){
            flag =true;
        }
        boolean isEnd(){
            return flag;
        }

    }
    //Trie class
    private Node root;

    //Constructor to initialize the Trie with an empty root node
    public Trie1(){
        root=new Node();
    }
    //Insert a word into the Trie
    //TC 0(len) . where len is the length of the word
    public void insert(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containKey(word.charAt(i))){
                //if not present create a node
                node.put(word.charAt(i),new Node());
            }
            //move to the next node
            node=node.get(word.charAt(i));
        }
        node.setEnd();
    }

    //return if the word is in the trie
    public boolean search(String word){
        Node node=root;
        for(int i=0;i<word.length();i++){
            if(!node.containKey(word.charAt(i))){
                //if letter is not found return false
                return false;
            }
            //move to the next node
            node=node.get(word.charAt(i));
        }
        //check if the last node mark the end of a word
        return node.isEnd();
    }

    public boolean startsWith(String prefix){
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            if(!node.containKey(prefix.charAt(i))){
                //if a letter is not found there is no word with the given prefix
                return false;
            }
            //move to the next node
            node=node.get(prefix.charAt(i));
        }
        //the prefix is dound in the trie
        return true;//no need to reach the end
    }
    public static void main(String[] args) {
        Trie1 trie = new Trie1();
        System.out.println("Inserting words: Striver, Striving, String, Strike");
        trie.insert("striver");
        trie.insert("striving");
        trie.insert("string");
        trie.insert("strike");

        System.out.println("Search if Strawberry exists in trie: " +
                (trie.search("strawberry") ? "True" : "False"));

        System.out.println("Search if Strike exists in trie: " +
                (trie.search("strike") ? "True" : "False"));

        System.out.println("If words in Trie start with Stri: " +
                (trie.startsWith("stri") ? "True" : "False"));
    }
}
