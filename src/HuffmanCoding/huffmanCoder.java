package HuffmanCoding;

import java.util.*;

 class huffmanCoder {//Wrong output....refer  to Huffman code
    HashMap<Character,String> encoder;
    HashMap<String,Character> decoder;
    private class Node implements Comparable<Node>{
        Character data;
        int cost;//frequency
        Node left;
        Node right;

        public Node(Character data,int cost){
            this.data=data;
            this.cost=cost;
            this.left=null;
            this.right=null;
        }

        @Override//override so as to tell on what basis we have to compare here we are taking on the basis of cost
        public int compareTo(Node other) {
            return this.cost-other.cost;
        }
    }
    public  huffmanCoder(String feeder)throws Exception{//for making frequency map
        HashMap<Character,Integer> fmap=new HashMap<>();
        for(int i=0;i<feeder.length();i++){
            char cc=feeder.charAt(i);
            if(fmap.containsKey(cc)){
                int ov=fmap.get(cc);//if original value already exists then get it and increse its count by 1
                ov=+1;
                fmap.put(cc,ov);//and put it in the map
            }else {
                fmap.put(cc,1);//doesnt exist so put 1 as this is the first time i am getting it
            }
        }
        //now creating min heap
        Heap<Node> minheap= new Heap<>();
        Set<Map.Entry<Character,Integer>> entrySet=fmap.entrySet();//it is creating set of all the entries in the map
    for (Map.Entry<Character,Integer> entry:entrySet){
        Node node=new Node(entry.getKey(),entry.getValue());
        minheap.insert(node);
    }
    //now remove 2 smallest heap
    while (minheap.size()!=1){
        Node first=minheap.remove();
        Node second=minheap.remove();
        Node newNode=new Node('\0',first.cost+second.cost);
        newNode.left=first;
        newNode.right=second;
        minheap.insert(newNode);
    }
    Node ft=minheap.remove();//to get the final tree node
        //now ctreate encoder and decoder
        this.encoder=new HashMap<>();
        this.decoder=new HashMap<>();
        this.initEncoderDecoder(ft, "");//method for inserting value
    }
    private void initEncoderDecoder(Node node,String osf){
        if(node == null){
            return;
        }
        if(node.left==null&&node.right==null){
            this.encoder.put(node.data,osf);
            this.decoder.put(osf,node.data);
        }
        initEncoderDecoder(node.left,osf+"0");
        initEncoderDecoder(node.right,osf+"1");
    }
    //now final step to encode and decode
    public String encode(String source){
        String ans = "";
        for (int i=0;i<source.length();i++){
            ans=ans+encoder.get(source.charAt(i));
        }
        return ans;
    }
    public String decode(String codedString){
        String key="";
        String ans="";
        for (int i=0;i<codedString.length();i++){
            key=key+codedString.charAt(i);
            if(decoder.containsKey(key)) {//if that contains that character them get it
                ans = ans + decoder.get(key);
                key = "";//make it empty again
            }
        }
        return ans;
    }

    public static void main(String[] args)throws Exception {
        String str="abbccda";
        huffmanCoder  hf=new huffmanCoder(str);
        String cs=hf.encode(str);
        System.out.println(cs);
        String ds= hf.decode(cs);
        System.out.println(ds);
    }

}
