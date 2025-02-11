import java.util.*;

public class Main{
    static int max = 0,n,m;
    static boolean[][] visit;
    static int[][] map;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            String[] str = sc.next().split("");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }

        dfs(0,0);
        System.out.println(max);
    }

    static void dfs(int x, int y){
        if(x==n){ // 조각 내기 끝
            sum();
            return;
        }
        if(y==m){
            dfs(x+1,0);
            return;
        }
        visit[x][y] = true; //가로로 자르기
        dfs(x,y+1);

        visit[x][y] = false; //세로로 자르기
        dfs(x,y+1);
    }

    static void sum(){
        int res = 0, tmp;
        for(int i=0;i<n;i++){
            tmp = 0;
            for(int j=0;j<m;j++){
                if(visit[i][j]){
                    tmp *= 10;
                    tmp += map[i][j];
                }else{
                    res+=tmp;
                    tmp = 0;
                }
            }
            res+=tmp;
        }
        for(int i=0;i<m;i++){
            tmp = 0;
            for(int j=0;j<n;j++){
                if(!visit[j][i]){
                    tmp *= 10;
                    tmp += map[j][i];
                }else{
                    res+=tmp;
                    tmp = 0;
                }
            }
            res+=tmp;
        }
        max = Math.max(max,res);
        return;
    }
}