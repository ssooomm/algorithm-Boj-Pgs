class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int)(right - left + 1);
        int[] res = new int[len];
        
        for (int i = 0; i < len; i++) {
            // 현재 숫자의 전체 평면에서의 위치(k)를 구함
            long k = left + i;
            
            // k를 이용해 행(row)과 열(col) 계산 (반드시 long으로 계산)
            long row = k / n;
            long col = k % n;
            
            // 행과 열 중 큰 값 + 1이 해당 칸의 숫자
            res[i] = (int)Math.max(row, col) + 1;
        }
        
        return res;
    }
}