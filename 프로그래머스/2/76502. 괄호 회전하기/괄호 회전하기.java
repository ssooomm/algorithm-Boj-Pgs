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
    
    boolean check(String s){
        Deque<Character> q = new ArrayDeque<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='['||s.charAt(i)=='{'||s.charAt(i)=='('){
                q.push(s.charAt(i));
                continue;
            }
            if(q.isEmpty()) return false;
            if(s.charAt(i)==']'){
                if(q.peek()=='[') q.pop();
            }
            else if(s.charAt(i)=='}'){
                if(q.peek()=='{') q.pop();
            }
            else if(s.charAt(i)==')'){
                if(q.peek()=='(') q.pop();
            }
        }
        if(q.isEmpty()) return true;
        else return false;
    }
}