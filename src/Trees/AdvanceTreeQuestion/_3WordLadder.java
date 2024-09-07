package Trees.AdvanceTreeQuestion;

import java.util.*;

public class _3WordLadder {//Word Ladder
    public int ladderLength(String beginWord, String endWord, List<String>wordList){
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> visited=new HashSet<>();
        Queue<String> q=new LinkedList<>();
        q.offer(beginWord);
        int length=0;
        while(!q.isEmpty()){
            int size=q.size();
            length++;

            for(int i=0;i<size;i++){
                String current=q.poll();
                for(int j=0;j<current.length();j++){
                    char[]temp=current.toCharArray();//convert that string to character
                    for(char c='a';c<='z';c++){
                        temp[j]=c;//trying every posibility from a to z like ait,bit...
                        String newWord=new String(temp);//converting those charcter to string
                        if(newWord.equals(endWord)){
                            return length+1;
                        }
                        if(wordList.contains(newWord)&&!visited.contains(newWord)){//if that word is not equal to endword but it is there in wordlist and is not visted then offer it in queue and add it in hashset.
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
