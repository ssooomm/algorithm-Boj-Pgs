import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] arr = s.split(" ");
        // List<String> list = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        
        for(String str: arr){
            if(str.equals("Z")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else{
                stack.push(Integer.parseInt(str));
            }
        }
        for(int n:stack){
            answer+=n;
        }
        return answer;
    }
}