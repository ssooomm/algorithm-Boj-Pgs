import java.util.*;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] arr = my_string.split("");
        Set<String> s = new LinkedHashSet<>();
        for(String a:arr){
            s.add(a);
        }
        for(String tmp:s){
            answer+=tmp;
        }
        return answer;
    }
}