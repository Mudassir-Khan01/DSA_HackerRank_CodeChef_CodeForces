package Graph;
import java.util.*;
public class _27WordLadder1 {
    public int wordLadderLength(String startword,String targetWord ,String[] wordlist ){
        Queue<Pairrr> q=new LinkedList<>();
        q.add(new Pairrr(startword,1));
        Set<String> st=new HashSet<String>();
        int len=wordlist.length;
        for(int i=0;i<len;i++){
            st.add(wordlist[i]);
        }
        st.remove(startword);
        while (!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            //we found the steps as soon as
            //the first occurence of target word is found
            if(word.equals(targetWord)==true)return steps;
            //now replace each character of word with char
            //from a-z then check if word exists in wordlist
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char replacedchararray[]=word.toCharArray();
                    replacedchararray[i]=ch;
                    String replaceword=new String(replacedchararray);
                    if(st.contains(replaceword)==true){
                        st.remove(replaceword);
                        q.add(new Pairrr(replaceword,steps+1));
                    }
                }
            }
        }
        return 0;//if there is no transformation sequence possible
    }
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        _27WordLadder1 obj = new _27WordLadder1();
        int ans = obj.wordLadderLength(startWord, targetWord, wordList);

        System.out.print(ans);

        System.out.println();
    }
}
class Pairrr {
    String first;
    int second;
    Pairrr(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
