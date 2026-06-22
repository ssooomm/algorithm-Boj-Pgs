import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int n = cards.length;
        boolean[] flag = new boolean[n];
        
        // int idx=0;
        // int f=0,s=0;
        List<Integer> list = new ArrayList<>();
        
        for(int idx=0;idx<n;idx++){
            int cnt=0;
            while(!flag[idx]){
                flag[idx] = true;
                int val = cards[idx];
                idx = val-1;
                cnt++;
            }
            if(cnt==n) return 0;
            else list.add(cnt);
        }
        list.sort(Comparator.reverseOrder());
        // Collections.sort(list);
        // System.out.println(list);
        return list.get(0)*list.get(1);
    }
}