import java.util.*;

class WordState{
    int cnt;
    String word;
    WordState(int cnt, String word){
        this.cnt = cnt;
        this.word = word;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Queue<WordState> q = new ArrayDeque<>();
        q.add(new WordState(0,begin));
        
        boolean[] visited = new boolean[words.length];
        
        while(!q.isEmpty()){
            WordState curr = q.remove();
            if(curr.word.equals(target)) return curr.cnt;
            for(int i=0;i<words.length;i++){
                if(!visited[i] && getDiff(curr.word,words[i])==1){
                    q.add(new WordState(curr.cnt+1, words[i]));
                    visited[i] = true;
                }
            }
        }
        return answer;
    }
    
    public int getDiff(String target, String cmp){
        int cnt = 0;
        for(int i=0;i<target.length();i++){
            if(target.charAt(i) != cmp.charAt(i)) cnt++;
        }
        return cnt;
    }
}