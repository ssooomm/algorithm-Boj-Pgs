import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(')
                dq.add(ch);
            else{
                if(dq.isEmpty()) return false;
                if(dq.peek()=='(') 
                    dq.pop();
                else return false;
            }
        }
        if(dq.isEmpty()) 
            return true;
        else return false;
    }
}