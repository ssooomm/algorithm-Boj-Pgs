import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String,Integer> hm = new HashMap<>();
        for(int i=0;i<want.length;i++){
            hm.put(want[i],number[i]);
        }
        Map<String,Integer> tmp= new HashMap<>();
        for(int i=0;i<discount.length;i++){
            tmp.put(discount[i],tmp.getOrDefault(discount[i],0)+1);
            if(i>=9){
                boolean flag = false;
                for(String k:hm.keySet()){
                    if(hm.get(k)!=tmp.get(k)){
                        flag = true;
                        break;
                    }
                }
                if(!flag) answer++;
                tmp.put(discount[i-9],tmp.get(discount[i-9])-1);
            }
            
        }
    
        return answer;
    }
}