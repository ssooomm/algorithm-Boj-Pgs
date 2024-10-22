class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;
        int ch =chicken;
        while(ch>0){
            ch = coupon/10;
            answer+=ch;
            coupon %=10;
            coupon+=ch;
        }
        return answer;
    }
}