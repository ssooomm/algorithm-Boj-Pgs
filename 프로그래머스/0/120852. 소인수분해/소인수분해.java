import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        Set<Integer> arr = new HashSet<Integer>();
        // int sq = (int)Math.sqrt(n);
        while(n>1){
            for(int i=2;i<=n;i++){
                if(n%i==0){
                    arr.add(i);
                    n/=i;
                    break;
                }
            }
        }
        
        // if(arr.size()==0) arr.add(n);
        
        int[] answer = new int[arr.size()];
        int i=0;
        for(int num:arr){
            answer[i++] = num;
        }
        Arrays.sort(answer);
        return answer;
    }
}