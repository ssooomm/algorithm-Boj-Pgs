import java.util.*;

public class Main{
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int r, c, max = 0;
    static char[][] map;
    static Set<Character> set = new HashSet<>();
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];
        for(int i=0;i<r;i++){
            String str = sc.next();
            for(int j=0;j<c;j++){
                map[i][j] = str.charAt(j);
            }
        }

        dfs(new int[]{0,0});
        
        System.out.println(max);
    }
    
    static public void dfs(int[] cor){
        set.add(map[cor[0]][cor[1]]);
        for(int i=0;i<4;i++){
            int nx = cor[0]+dx[i];
            int ny = cor[1]+dy[i];
            if(nx>=0&&nx<r&&ny>=0&&ny<c){
                if(!set.contains(map[nx][ny])){
                    dfs(new int[]{nx,ny});
                }
            }
        }
        max = Math.max(set.size(),max);
        set.remove(map[cor[0]][cor[1]]);
        return;
    }
}