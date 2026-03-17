class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0,1000000};
        
        int l=0;
        int r=0;
        int sum=0;
        while(l<=r){
            if(sum==k){
                if(r-l-1<answer[1]-answer[0]){
                    answer[0] = l;
                    answer[1] = r-1;
                }
            }
            
            if(sum<=k){
                if(r>=sequence.length) break;
                sum+=sequence[r++];
            }else{
                sum-=sequence[l++];
            }
            
        }
        return answer;
    }
}