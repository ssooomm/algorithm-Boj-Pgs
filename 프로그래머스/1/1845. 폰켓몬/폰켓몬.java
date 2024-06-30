import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int n:nums){
            hm.put(n, hm.getOrDefault(n, 0) + 1);
        }
        int n = nums.length / 2;

        int max = hm.size();
        if(max>n) answer = n;
        else answer = max;
        return answer;
    }
}