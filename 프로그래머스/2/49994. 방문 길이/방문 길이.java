import java.util.*;

class Solution {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public int solution(String dirs) {
        int x=5;
        int y=5;
        int num=0;
        
        Set<String> hs = new HashSet<>();
        
        for(int i=0;i<dirs.length();i++){
            
            
            char ch = dirs.charAt(i);
            if(ch=='U') num=0;
            else if(ch=='D') num=1;
            else if(ch=='R') num=2;
            else if(ch=='L') num=3;
            
            int nx = x+dx[num];
            int ny = y+dy[num];
            
            if(nx<0||nx>10||ny<0||ny>10) continue;
            
            StringBuilder sb = new StringBuilder();
            sb.append(x).append(y);
            sb.append(nx).append(ny);
            hs.add(sb.toString());
            sb = new StringBuilder();
            sb.append(nx).append(ny);
            sb.append(x).append(y);
            hs.add(sb.toString());
            x=nx;
            y=ny;
        }
        
        return hs.size()/2;
    }
}