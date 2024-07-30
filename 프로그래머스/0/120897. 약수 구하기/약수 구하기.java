import java.util.*;

class Solution {
    public int[] solution(int n) {
        // int[] answer = {};
        
        Set<Integer> arr = new HashSet<>();
        int n_sqrt = (int)Math.sqrt(n);
        for(int i=1;i<=n_sqrt;i++){
            if(n%i==0){
                arr.add(i);
                arr.add(n/i);
            }
        }
        
        int[] answer = new int[arr.size()];
        int index = 0;

        for (Integer num : arr) {
            answer[index++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }
}