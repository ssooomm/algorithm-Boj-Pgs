import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        
        Set<String> pset = new HashSet<>();
        for(String p:phone_book){
            String tmp="";
            for(String sub:p.split("")){
                tmp+=sub;
                if(pset.contains(tmp)) return false;
            }
            
            pset.add(p);
        }
        return answer;
    }
}