import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String ss = s+s;
        for(int i=0;i<s.length();i++){
            if(check(ss.substring(i,i+s.length()))){
                answer++;
            }
        }
        return answer;
    }
    
    boolean check(String str){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean flag = true;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('||ch=='{'||ch=='[') stack.push(ch);
            else{
                if(stack.isEmpty()){
                    flag = false;
                    break;
                }
                if(stack.peek()=='['&&ch==']') stack.pop();
                else if(stack.peek()=='{'&&ch=='}') stack.pop();
                else if(stack.peek()=='('&&ch==')') stack.pop();
                else{
                    flag = false;
                    break;
                }
            }
            
        }
        if(stack.isEmpty()&&flag) return true;
        return false;
    }
}