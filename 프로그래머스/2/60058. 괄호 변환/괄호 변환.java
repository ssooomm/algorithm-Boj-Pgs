import java.util.*;

class Solution {
    public String solution(String p) {
        String answer = "";
        
        answer = fun(p);
        return answer;
    }
    
    public String fun(String str){
        if(str.equals("")) return "";
        int l=0, r=0, idx=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==')') r++;
            else if(str.charAt(i)=='(') l++;
            if(l==r){
                idx=i;
                break;
            }
        }
        String u = str.substring(0,idx+1);
        String v = str.substring(idx+1);
        
        if(check(u)) return u+fun(v);
        else{
            String vtmp = "(" + fun(v) + ")";
            String utmp="";
            for(int i=1;i<u.length()-1;i++){
                if(u.charAt(i)=='(') utmp+=")";
                else utmp+="(";
            }   

            return vtmp+utmp;
            
        }
    }
    
    public boolean check(String u){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<u.length();i++){
            char ch = u.charAt(i);
            
            if(ch=='(') stack.push(ch);
            else{
                if(stack.isEmpty()) return false;
                else{
                    stack.pop();
                }
            }
        }
        if(stack.isEmpty()) return true;
        else return false;
    }
}