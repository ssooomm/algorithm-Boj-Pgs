class Solution {
    public int solution(int n, int k) {
        int s = n/10;
        int answer = n*12000 + 2000*(k-s);
        return answer;
    }
}