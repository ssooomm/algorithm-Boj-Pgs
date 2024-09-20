class Solution {
    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,1,-1};
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {};
        int[] st = {0,0};
        int x = board[0]/2;
        int y = board[1]/2;
        int r = x;
        int l = x*(-1);
        int u = y;
        int d = y*(-1);
        for(String key:keyinput){
            if(key.equals("left")){
                st[0]--;
                if(st[0]<l) st[0] = l;
            }
            else if(key.equals("right")){
                st[0]++;
                if(st[0]>r) st[0] = r;
            }
            else if(key.equals("up")){
                st[1]++;
                if(st[1]>u) st[1] = u;
            }
            else if(key.equals("down")){
                st[1]--;
                if(st[1]<d) st[1] = d;
            }
        }
        return st;
    }
}