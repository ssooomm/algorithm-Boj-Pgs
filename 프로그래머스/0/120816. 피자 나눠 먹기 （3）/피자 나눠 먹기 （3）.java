class Solution {
    public int solution(int slice, int n) {
        int div = n/slice;
        int answer = (n%slice==0)? div:div+1;
        return answer;
    }
}