import java.util.*;

class Solution {
    public String solution(String my_string) {
        List<String> moeums = new LinkedList<String>();
        moeums.add("a");
        moeums.add("e");
        moeums.add("i");
        moeums.add("o");
        moeums.add("u");
        List<String> str = new LinkedList<>();

        for(String s:my_string.split("")){
            if(!moeums.contains(s)){
                str.add(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(String s:str){
            sb.append(s);
        }
        return sb.toString();
        
    }
}