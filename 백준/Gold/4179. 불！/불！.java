import java.util.*;

public class Main{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] arr = new char[r][c];
        
        int[][] jarr = new int[r][c];
        int[][] farr = new int[r][c];
        Queue<int[]> jq = new ArrayDeque<>();
        Queue<int[]> fq = new ArrayDeque<>();
        for(int i=0;i<r;i++){
            String str = sc.next();
            for(int j=0;j<c;j++){
                arr[i][j] = str.charAt(j);
                jarr[i][j] = -1;
                farr[i][j] = -1;
                if(arr[i][j]=='J'){
                    jq.add(new int[]{i,j});
                    jarr[i][j] = 0;
                }
                else if(arr[i][j]=='F'){
                    fq.add(new int[]{i,j});
                    farr[i][j]=0;
                }
            }
        }
        
        // 불이 난 곳은 여러 곳
        while(!fq.isEmpty()){
            int[] cur = fq.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx>=0&&nx<r&&ny>=0&&ny<c){
                    if(arr[nx][ny]!='#'&&farr[nx][ny]==-1){ //불 번지는 곳
                        farr[nx][ny] = farr[cur[0]][cur[1]]+1;
                        fq.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
        while(!jq.isEmpty()){
            int[] cur = jq.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx<0||nx>=r||ny<0||ny>=c){
                    System.out.println(jarr[cur[0]][cur[1]]+1);
                    return;
                }
                if(arr[nx][ny]=='.' && jarr[nx][ny]==-1){
                    //불 도달 전이거나, 불 보다 먼저 도달 
                    if(farr[nx][ny]==-1 || jarr[cur[0]][cur[1]]+1 < farr[nx][ny]){
                        jarr[nx][ny] = jarr[cur[0]][cur[1]]+1;
                        jq.add(new int[]{nx,ny});
                    }
                }
            }
        }
        
        System.out.println("IMPOSSIBLE");
        return;
    }
}