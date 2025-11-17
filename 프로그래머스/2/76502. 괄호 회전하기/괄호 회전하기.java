import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = s+s;
        
        for(int i=0;i<s.length();i++){
            if(check(str.substring(i,s.length()+i))) answer++;
        }
        
        return answer;
    }
    
    boolean check(String str){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                stack.push(ch);
            }else{
                if(stack.isEmpty()) return false;
                
                if(ch==')'&&stack.peek()=='(')
                    stack.pop();
                else if(ch=='}'&&stack.peek()=='{')
                    stack.pop();
                else if(ch==']'&&stack.peek()=='[')
                    stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}