import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        int[] copy = Arrays.copyOf(priorities,priorities.length);
        Arrays.sort(copy);
        
        Queue<int[]> q = new ArrayDeque<>();
        for(int i=0;i<priorities.length;i++){
            q.add(new int[]{i,priorities[i]});
        }
        
        int x = priorities.length-1;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[1]==copy[x]){
                if(tmp[0]==location) return answer;
                x--;
                answer++;
            }
            else{
                q.add(tmp);
            }
        }
        return answer;
    }
}