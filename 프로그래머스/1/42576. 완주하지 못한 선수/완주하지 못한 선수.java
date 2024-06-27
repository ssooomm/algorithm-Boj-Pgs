import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
                HashMap<String,Integer> hm = new HashMap<>();

//        getOrDefault - 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환하는 메서드
        for(String p:participant){
            hm.put(p,hm.getOrDefault(p,0)+1);
        }
        for(String c:completion){
            hm.put(c,hm.get(c)-1);
        }
        for(String key:hm.keySet()){
            if(hm.get(key)!=0){
                answer += key;
            }
        }
        return answer;
    }
}