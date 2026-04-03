import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> nums = new ArrayList<>();
        long fct=1;
        
        for(int i=1;i<=n;i++){
            nums.add(i);
            fct*=i;
        }
        
        k--; //k를 0부터 시작으로
        
        for(int i=0;i<n;i++){
            fct /=(n-i); //(n-i-1)!
            
            int idx = (int) (k/fct);
            answer[i] = nums.get(idx);
            
            nums.remove(idx); //한 번 사용한 숫자는 제거
            
            k%=fct;
        }
        
        return answer;
    }

}