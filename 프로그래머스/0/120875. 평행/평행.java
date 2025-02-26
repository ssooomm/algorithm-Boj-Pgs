import java.util.*;

class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        // 0,1 / 2,3 
        // 0,2 / 1,3
        // 0,3 / 1,2
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{0,1,2,3});
        list.add(new int[]{0,2,1,3});
        list.add(new int[]{0,3,1,2});
        
        for(int[] arr:list){
            double tmp1 = (double)(dots[arr[0]][1] - dots[arr[1]][1])/(dots[arr[0]][0] - dots[arr[1]][0]);
            double tmp2 = (double)(dots[arr[2]][1] - dots[arr[3]][1])/(dots[arr[2]][0] - dots[arr[3]][0]);
            if(tmp1==tmp2) return 1;
        }
        
        return answer;
    }
}