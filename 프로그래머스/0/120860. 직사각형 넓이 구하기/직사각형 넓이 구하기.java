class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        int x = Math.abs(dots[0][0] - dots[1][0]);
        if(x==0) x = Math.abs(dots[0][0] - dots[2][0]);
        
        int y = Math.abs(dots[0][1] - dots[1][1]);
        if(y==0) y = Math.abs(dots[0][1] - dots[2][1]);
        
        return x*y;
    }
}