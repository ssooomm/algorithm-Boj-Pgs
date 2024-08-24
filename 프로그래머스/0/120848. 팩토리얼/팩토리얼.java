class Solution {
    public int solution(int n) {
        int answer = 0;
        int idx = 1;
        while(true){
            if(n<idx) return idx-1;
            n/=idx;
            if(n>1) idx++;
            else break;
        }
        
        return idx;
    }
}