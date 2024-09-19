import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        Map<String,Integer> map = new HashMap<>();
        for(String sp:spell){
            for(String d:dic){
                if(d.contains(sp)){
                    map.put(d,map.getOrDefault(d,0)+1);
                }
            }
        }
        for(int n:map.values()){
            if(n==spell.length) answer = 1;
        }
        
        return answer;
    }
}