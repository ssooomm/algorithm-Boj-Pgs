import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] day = new int[progresses.length];
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i=0;i<progresses.length;i++){
            q.add((int)Math.ceil((double)(100-progresses[i])/speeds[i]));
        }
        
        int x = q.poll();
        int cnt=1;
        while(!q.isEmpty()){
            if(x>=q.peek()){
                cnt++;
                q.poll();
            }else{
                list.add(cnt);
                cnt=1;
                x=q.poll();
            }
        }
        list.add(cnt);
        
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}