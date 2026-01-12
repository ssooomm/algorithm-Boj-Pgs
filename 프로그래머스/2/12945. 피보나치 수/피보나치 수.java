class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        
        if(n==0) return 0;
        if(n==1) return 1;
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2;i<=n;i++){
            int tmp = dp[i-2]+dp[i-1];
            dp[i] = tmp%1234567;
        }
        
        
        return dp[n];
    }

}