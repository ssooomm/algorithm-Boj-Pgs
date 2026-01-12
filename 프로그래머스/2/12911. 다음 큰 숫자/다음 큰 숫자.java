class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int ans = n+1;
        while(true){
            if(cnt==Integer.bitCount(ans)){
                break;
            }
            ans++;
        }
        return ans;
    }
}