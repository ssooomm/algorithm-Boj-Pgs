import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int len = arr.length;
        int[] nums = new int[len];
        for(int i=0;i<len;i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(nums);
        answer+=nums[0]+" "+nums[len-1];
        return answer;
    }
}