class Solution {
    public int solution(String[] board) {
        
        int n = board.length;
        int o=0,x=0;        
        for(int i=0;i<n;i++){
            String str = board[i];
            for(int j=0;j<n;j++){
                char ch = str.charAt(j);
                if(ch=='O') o++;
                else if(ch=='X') x++;
            }
        }
        
        if(o<x) return 0;
        if(o-x>1) return 0;
        
        
        boolean owin = check('O',board);
        boolean xwin = check('X',board);
        
        if(owin&&xwin) return 0;
        if(owin){
            if((o!=x+1)) return 0;
        }
        if(xwin){
            if(x!=o) return 0;
        }
        
        return 1;
    }
    
    boolean check(char ch,String[] board){
        if(board[0].charAt(0)==ch&&board[0].charAt(1)==ch&&board[0].charAt(2)==ch)
            return true;
        if(board[1].charAt(0)==ch&&board[1].charAt(1)==ch&&board[1].charAt(2)==ch)
            return true;
        if(board[2].charAt(0)==ch&&board[2].charAt(1)==ch&&board[2].charAt(2)==ch)
            return true;

        if(board[0].charAt(0)==ch&&board[1].charAt(0)==ch&&board[2].charAt(0)==ch)
            return true;
        if(board[0].charAt(1)==ch&&board[1].charAt(1)==ch&&board[2].charAt(1)==ch)
            return true;
        if(board[0].charAt(2)==ch&&board[1].charAt(2)==ch&&board[2].charAt(2)==ch)
            return true;

        if(board[0].charAt(0)==ch&&board[1].charAt(1)==ch&&board[2].charAt(2)==ch)
            return true;
        if(board[2].charAt(0)==ch&&board[1].charAt(1)==ch&&board[0].charAt(2)==ch)
            return true;
        
        return false;
    }
    
}