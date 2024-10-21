class Solution {
    int[] dx = {0,0,1,-1,1,-1,1,-1};
    int[] dy = {1,-1,0,0,1,-1,-1,1};
    
    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==1){
                    for(int x=0;x<8;x++){
                        int nx = i+dx[x];
                        int ny = j+dy[x];
                        if(nx>=0&&nx<n&&ny>=0&&ny<n){
                            if(board[nx][ny]!=1) board[nx][ny] = 2;
                        }
                    }
                }
            }
        }
        for(int[] i:board){
            for(int j:i){
                if(j==0) answer++;
            }
        }
        return answer;
    }
}