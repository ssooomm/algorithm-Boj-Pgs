class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum=0,idx=n;
        for(int i=n;i>0;i--){
            sum+=i;
            if(sum==n) answer++;
            else if(sum>n){
                sum-=idx;
                idx--;
            }
        }
        return answer;
    }
}