
class Solution {
    public int solution(int n) {
        int answer = 0;
        int sqrt = (int)Math.sqrt(n);
        for(int i=1;i<=sqrt;i++){
            int tmp = n/i;
            if(n==tmp*i) answer++;
        }
        if(sqrt*sqrt == n) return answer*2-1;
        return answer*2;
    }
}