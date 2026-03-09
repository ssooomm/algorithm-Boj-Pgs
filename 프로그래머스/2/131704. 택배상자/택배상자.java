import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        int n = order.length;
        int st = order[0];
        
        for(int i=1;i<st;i++){
            stack.push(i);
        }
        for(int i=st;i<=n;i++){
            q.add(i);
        }
        
        for(int i=0;i<n;i++){
            int o = order[i];
            if(!q.isEmpty()&&q.peek()==o){
                q.poll();
                answer++;
            }
            else if(!stack.isEmpty()&&stack.peek()==o){
                stack.pop();
                answer++;
            }
            else{
                if(q.isEmpty()) break;
                else{
                    stack.push(q.poll());
                    i--;
                }
            }
        }
        
        return answer;
    }
}