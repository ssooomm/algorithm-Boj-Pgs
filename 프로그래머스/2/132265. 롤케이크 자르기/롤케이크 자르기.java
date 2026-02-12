import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> hs = new HashSet<>();
        Map<Integer,Integer> hm = new HashMap<>();
        for(int t:topping){
            hm.put(t,hm.getOrDefault(t,0)+1);
        }
        int size = topping.length;
        int b = hm.size();
        
        for(int t:topping){
            hs.add(t);
            int tmp = hm.get(t);
            if(tmp==1){
                b--;
            }
            hm.put(t,tmp-1);
            if(hs.size()==b) answer++;
        }
        return answer;
    }
}