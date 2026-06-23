class Solution {
    public int solution(int n) {
        boolean[][] board = new boolean[n][n];
        
        return check(board,0,n);
    }
    
    int check(boolean[][] board,int r,int n){
        
        if(r==n){
            return 1;
        }
        
        int cnt=0;
        for(int c=0;c<n;c++){
            if(isValid(board,r,c,n)){
                board[r][c] = true;
                cnt+=check(board,r+1,n);
                board[r][c] = false;
            }
        }

        return cnt;
    }

    
    boolean isValid(boolean[][] board, int r, int c, int n){
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