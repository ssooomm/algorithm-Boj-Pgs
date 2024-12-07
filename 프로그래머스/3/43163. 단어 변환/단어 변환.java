import java.util.*;

class WS{
    int cnt;
    String word;
    WS(int cnt, String word){
        this.cnt = cnt;
        this.word = word;
    }
}
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        boolean[] visited = new boolean[words.length];
        Queue<WS> q = new ArrayDeque<>();
        q.add(new WS(0,begin));
        
        
        while(!q.isEmpty()){
            WS curr = q.remove();
            if(curr.word.equals(target)) return curr.cnt;
            for(int i=0;i<words.length;i++){
                if(!visited[i]&&getDiff(curr.word,words[i])==1){
                    q.add(new WS(curr.cnt+1, words[i]));
                    visited[i] = true;
                }
            }
        }
        return answer;
    }
    
    public int getDiff(String target, String com){
        int cnt=0;
        for(int i=0;i<target.length();i++){
            if(target.charAt(i)!=com.charAt(i)) cnt++;
        }
        return cnt;
    }
}