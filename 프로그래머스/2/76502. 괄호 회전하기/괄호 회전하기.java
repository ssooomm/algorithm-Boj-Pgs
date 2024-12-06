import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        String ext = s+s;
        
        for(int i=0;i<ext.length()-len;i++){
            if(isStack(ext.substring(i,i+len))){
                answer++;
            }
        }
        return answer;
    }

    public boolean isStack(String str){
        char[] arr = str.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        for(int j=0;j<arr.length;j++){
            if(arr[j]=='('||arr[j]=='['||arr[j]=='{'){
                stack.push(arr[j]);
            }else{
                if(stack.isEmpty()) return false;

                if(arr[j]==')'&&stack.peek()=='('){
                    stack.pop();
                }
                else if(arr[j]=='}'&&stack.peek()=='{'){
                    stack.pop();
                }
                else if(arr[j]==']'&&stack.peek()=='['){
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
        
    }
    
}