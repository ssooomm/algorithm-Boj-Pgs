class Solution {
    public int solution(int n) {
        boolean[][] board = new boolean[n][n];
        return place(board,0,n);
    }
    int place(boolean[][] board, int r, int n){
        if(r==n) return 1;
        int cnt = 0;
        
        for(int col=0;col<n;col++){
            if(!board[r][col] && check(board,r,col,n)){
                board[r][col] = true;
                cnt += place(board,r+1,n);
                board[r][col] = false;
            }
        }
        return cnt;
    }
    
    boolean check(boolean[][] board, int r, int c, int n){
        for(int i=0;i<r;i++){
            if(board[i][c]) return false;
        }
        
        for(int i=r-1,j=c-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]) return false;
        }
        for(int i=r-1,j=c+1;i>=0&&j<n;i--,j++){
            if(board[i][j]) return false;
        }
        return true;
    }
}