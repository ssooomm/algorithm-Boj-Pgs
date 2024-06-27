import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] arr = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                list.add("(");
            }
            else if(arr[i] == ')') {
                if(list.isEmpty()){
                    answer = false;
                    break;
                }
                list.remove("(");
            }
        }
        if(!list.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}