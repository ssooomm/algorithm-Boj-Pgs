class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int r = land.length;
        int c = land[0].length;
        int[][] dp = new int[r+1][c];
        
        for(int i=r-1;i>=0;i--){
            for(int j=0;j<c;j++){
                int max=0;
                for(int x=0;x<c;x++){
                    if(j==x) continue;
                    max = Math.max(dp[i+1][x],max);
                }
                dp[i][j]=land[i][j]+max;
            }
        }

        for(int i=0;i<c;i++){
            answer = Math.max(answer,dp[0][i]);
        }
        return answer;
    }
}