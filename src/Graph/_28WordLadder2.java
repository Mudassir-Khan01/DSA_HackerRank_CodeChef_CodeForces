package Graph;
import java.util.*;
public class _28WordLadder2 {
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord,
                                                      String[] wordList){
    //push all the values of the wordlist into a set
    //to make deletion from it easier and in less time complexity
    Set<String> st=new HashSet<>();
    int len=wordList.length;
    for(int i=0;i<len;i++){
        st.add(wordList[i]);
    }
    //creating a quewue which stores teh words in a sequence which
        // is required to reach ythe target word after successsive transformation
        Queue<ArrayList<String>> q=new LinkedList<>();
    ArrayList<String >ls=new ArrayList<>();
    ls.add(startWord);
    q.add(ls);
    ArrayList<String> usedONlevel=new ArrayList<>();
    usedONlevel.add(startWord);
    int level=0;
    //to store the resultant transformation sequence
        ArrayList<ArrayList<String >> ans=new ArrayList<>();
        int cnt=0;
        //bfs traversal with pushing the new formaed sequence in queue
        //when after a transformation , a word is found in wordlist
        while (!q.isEmpty()){
            cnt++;
            ArrayList<String>vec=q.peek();
            q.remove();
            //now erase all words that have been used in previous levels to transform
            if(vec.size()>level){
                level++;
                for(String it:usedONlevel){
                    st.remove(it);
                }
            }
            String word=vec.get(vec.size()-1);
            //stores the answer if the end word matches with target word
            if(word.equals(targetWord)){
                //the first sequence where we reached the end
                if(ans.size()==0){
                    ans.add(vec);
                }else if(ans.get(0).size()==vec.size()){
                    ans.add(vec);
                }
            }
            for (int i=0;i<word.length();i++){
                for(char c='a';c<='z';c++){
                    char replacedCharArray[]=word.toCharArray();
                    replacedCharArray[i]=c;
                    String repalcedWord=new String(replacedCharArray);
                    if(st.contains(repalcedWord)==true){
                        vec.add(repalcedWord);
                        //java works by reference , so enter the copy of the vec
                        //ptherwise if you remove the word from the vec in nect lines,it will
                        //remove form everywhere
                        ArrayList<String>temp=new ArrayList<>(vec);
                        q.add(temp);
                        //mark as visited on the level
                        usedONlevel.add(repalcedWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args)  {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };

        _28WordLadder2 obj = new _28WordLadder2();
        ArrayList < ArrayList < String >> ans = obj.findSequences(startWord, targetWord, wordList);

        // If no transformation sequence is possible.
        if (ans.size() == 0)
            System.out.println(-1);
        else {

            Collections.sort(ans, new comp());
            for (int i = 0; i < ans.size(); i++) {
                for (int j = 0; j < ans.get(i).size(); j++) {
                    System.out.print(ans.get(i).get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}
//a comparator class to sort the answer
class comp implements Comparator<ArrayList<String>>{
    public int compare(ArrayList<String>a,ArrayList<String>b){
        String x="";
        String y="";
        for(int i=0;i<a.size();i++){
            x=x+a.get(i);
        }
        for(int i=0;i<b.size();i++){
            y=y+b.get(i);
        }
        return x.compareTo(y);
    }
}
