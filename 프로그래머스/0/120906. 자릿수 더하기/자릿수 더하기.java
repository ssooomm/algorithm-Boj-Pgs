class Solution {
    public int solution(int n) {
        int answer = 0;
        String tmp = ""+n;
        for(int i=tmp.length()-1;i>=0;i--){
            int d = (int)Math.pow(10,i);
            answer += n/d;
            n %= d;
        }
        return answer;
    }
}