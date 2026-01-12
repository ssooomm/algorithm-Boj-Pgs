import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int t:tangerine){
            hm.put(t,hm.getOrDefault(t,0)+1);
        }
        
        int[] arr = new int[hm.size()];
        int idx=0;
        for(int x:hm.keySet()){
            arr[idx++] = hm.get(x);
        }
        Arrays.sort(arr);
        int sum=0,cnt=0;
        for(int i=hm.size()-1;i>=0;i--){
            sum+=arr[i];
            cnt++;
            if(sum>=k) break;
        }
        return cnt;
    }
}