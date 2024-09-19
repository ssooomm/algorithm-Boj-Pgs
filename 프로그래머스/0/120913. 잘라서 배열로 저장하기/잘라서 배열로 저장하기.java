import java.util.*;

class Solution {
    public String[] solution(String my_str, int n) {
        List<String> list = new ArrayList<>();
        
        for(int i=0;i<my_str.length();i+=n){
            String chunk = my_str.substring(i,Math.min(my_str.length(),i+n));
            list.add(chunk);
        }
        String[] answer = new String[list.size()];
        int i=0;
        for(String str:list){
            answer[i++] = str;
        }
        return answer;
    }
}