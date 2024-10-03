import java.util.*;

class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        Map<String,Integer> bMap = new HashMap<>();
        Map<String,Integer> aMap = new HashMap<>();
        
        String[] bArr = before.split("");
        String[] aArr = after.split("");
        for(String b:bArr){
            bMap.put(b,bMap.getOrDefault(b,0)+1);
        }
        for(String a:aArr){
            if(bMap.containsKey(a)){
                bMap.put(a,bMap.get(a)-1);
            }
        }
        for(int n:bMap.values()){
            if(n!=0) return 0;
        }
        
        return answer;
    }
}