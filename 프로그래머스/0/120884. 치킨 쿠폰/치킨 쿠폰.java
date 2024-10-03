class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while(chicken>=10){
            int tmp = chicken;
            chicken/=10;
            answer += chicken;
            chicken += tmp%10;
        }
        return answer;
    }
}