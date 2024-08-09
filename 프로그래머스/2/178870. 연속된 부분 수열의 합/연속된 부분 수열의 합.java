class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0,sequence.length-1};
        int st=0;
        int sum=0;
        
        for(int end=0;end<sequence.length;end++){
            if(sum<=k){
                sum+=sequence[end];
            }
            while(sum>k){
                sum-=sequence[st++];
            }
            if(sum==k){
                if(answer[1]-answer[0]>end-st){
                    answer[1] = end;
                    answer[0] = st;
                }
            }
            
        }
        return answer;
    }
}