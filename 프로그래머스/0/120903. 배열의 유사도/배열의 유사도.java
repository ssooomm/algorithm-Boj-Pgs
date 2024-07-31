import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        for(String str1:s1){
            for(String str2:s2){
                if(str1.equals(str2)) answer++;
            }
        }
        // String s2Str = "";
        // for(String s:s2){
        //     s2Str += s+"_";
        // }
        // for(String s:s1){
        //     if(s2Str.contains(s)) answer++;
        // }
        return answer;
    }
}