class Solution {
    public int solution(int[] numbers, int k) {
        int answer = 0;
        int cnt = 1,idx = 0;
        while(true){
            if(cnt==k) return idx+1;
            
            idx=(idx+2) % numbers.length;
            cnt++;
        }
    }
}