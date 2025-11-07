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
        Queue<WS> q = new ArrayDeque<>();
        q.add(new WS(0,begin));
        boolean[] v = new boolean[words.length];
        
        while(!q.isEmpty()){
            WS cur = q.poll();
            if(cur.word.equals(target)){
                return cur.cnt;
            }
            for(int i=0;i<words.length;i++){
                if(!v[i] && check(cur.word,words[i])){
                    v[i] = true;
                    q.add(new WS(cur.cnt+1,words[i]));
                }
            }
        }
        
        return 0;
    }
    
   
    
    static boolean check(String w, String tmp){
        int cnt=0;
        for(int i=0;i<w.length();i++){
            if(w.charAt(i)!=tmp.charAt(i)) cnt++;
            if(cnt>1) return false;
        }
        return true;
    }
}