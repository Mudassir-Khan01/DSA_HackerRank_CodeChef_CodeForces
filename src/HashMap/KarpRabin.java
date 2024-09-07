package HashMap;

public class KarpRabin {
    private final int Prime=101;

    private double calculateHash(String str){
        double hash=0;
        for(int i=0;i<str.length();i++){
            hash=hash+str.charAt(i)*Math.pow(Prime,i);
        }
        return hash;
    }
    private double updateHash(double prevHash,char oldChar,char newChar,int patternlength){
        double newHash=(prevHash-oldChar)/Prime;
        newHash=newHash+newChar*Math.pow(Prime,patternlength-1);
        return newHash;
    }
    private void search(String text,String pattern){
        int patterlength=pattern.length();
        double patterHash=calculateHash(pattern);
        double textHash=calculateHash(text.substring(0,patterlength));
        for(int i=0;i<=text.length()-patterlength;i++){
            if(textHash==patterHash){
                if (text.substring(i,i+patterlength).equals(pattern)){
                    System.out.println("Pattern found at index "+i);
                }
            }
            else if(i<text.length()-patterlength){
                textHash=updateHash(textHash,text.charAt(i),text.charAt(i+patterlength),patterlength);
            }else {
                System.out.println("Not found");
            }
        }
    }

    public static void main(String[] args) {
       KarpRabin algo=new KarpRabin();
       algo.search("ApoorvKunalRahul","Kunal");
    }
}
