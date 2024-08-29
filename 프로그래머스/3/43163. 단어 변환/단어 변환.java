import java.util.*;

class WordState{
    int cnt;
    String word;
    public WordState(int cnt, String word){
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
            WordState cur = q.remove();
            if(cur.word.equals(target)) return cur.cnt;
            for(int i=0;i<words.length;i++){
                if(!visited[i] && getDiff(cur.word, words[i])==1){
                    visited[i] = true;
                    q.add(new WordState(cur.cnt+1,words[i]));
                }
            }
        }
        return answer;
    }
    
    int getDiff(String cur, String target){
        int answer = 0;
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i)!=target.charAt(i)) answer++;
        }
        return answer;
    }
}