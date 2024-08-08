import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<WordState> q = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        q.add(new WordState(0,begin));
        
        while(!q.isEmpty()){
            WordState cur = q.remove();
            if(cur.word.equals(target)) return cur.cnt;
            for(int i=0;i<words.length;i++){
                if(!visited[i]&&getDiff(cur.word,words[i])==1){
                    visited[i] = true;
                    q.add(new WordState(cur.cnt+1,words[i]));
                }
            }
        }
        return answer;
    }
    int getDiff(String cur, String target){
        int cnt = 0;
        // for(String c:cur.split("")){
        //     if(!target.contains(c)) cnt++;
        // }
        for(int i=0;i<cur.length();i++){
            if(cur.charAt(i) != target.charAt(i)) cnt++;
        }
        return cnt;
    }
    class WordState{
        int cnt;
        String word;
        WordState(int cnt,String word){
            this.cnt = cnt;
            this.word = word;
        }
    }
}