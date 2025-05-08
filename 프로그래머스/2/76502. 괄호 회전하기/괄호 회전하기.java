import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        String str = s+s;
        for(int i=0;i<len;i++){
            ArrayDeque<Character> stack= new ArrayDeque<>();
            boolean flag = true;
            for(int j=i;j<i+len;j++){
                char ch = str.charAt(j);
                if(ch=='['||ch=='{'||ch=='('){
                    stack.push(ch);
                }else{
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
            if(flag && stack.isEmpty()) answer++;
        }
        
        return answer;
    }
}