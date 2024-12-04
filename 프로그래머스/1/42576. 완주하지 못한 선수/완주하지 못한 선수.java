import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> m = new HashMap<>();
        for(String p: participant){
            m.put(p,m.getOrDefault(p,0)+1);
        }
        for(String c:completion){
            m.put(c,m.get(c)-1);
        }
        for(String str:m.keySet()){
            if(m.get(str)!=0){
                return str;
            }
        }
        return answer;
    }
}