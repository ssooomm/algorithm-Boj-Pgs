class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long ans=0;
        for(int y=1;y<=r2;y++){
            long a = (long) Math.floor(Math.sqrt((long)r2 * r2 - (long)y * y));
            
            long b=0;
            if(r1>y){
                b = (long) Math.ceil(Math.sqrt((long)r1 * r1 - (long)y * y));
            }
            answer += a-b+1;
        }

        return answer*4;
    }
}