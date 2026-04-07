import java.util.*;

class Solution {
    static List<int[]> ans = new ArrayList<>();
    public int[][] solution(int n) {
        hanoi(n,1,2,3);
        int[][] answer = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            int[] cur = ans.get(i);
            answer[i][0] = cur[0];
            answer[i][1] = cur[1];
        }
        
        
        return answer;
    }
    
    public void hanoi(int n, int st, int mid, int end){
        if(n==1){
            ans.add(new int[]{st,end});
            return;
        }
        
        hanoi(n-1,st,end,mid);
        
        ans.add(new int[]{st,end});
        
        hanoi(n-1,mid,st,end);
    }
}