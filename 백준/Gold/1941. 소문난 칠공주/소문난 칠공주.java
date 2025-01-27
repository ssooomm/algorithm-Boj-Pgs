import java.io.*;
import java.util.*;

public class Main{
    static String[][] arr;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int cnt = 0;
    static int[] selected = new int[7];
    static boolean[] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new String[5][5];
        for(int i=0;i<5;i++){
            String[] tmp = br.readLine().split("");
            for(int j=0;j<5;j++){
                arr[i][j] = tmp[j];
            }
        }

        search(0,0,0);
        System.out.println(cnt);
    }

    static void search(int depth, int numY, int st){
        if(numY>=4) return; //임도연파가 4명 이상이면 안됨

        if(depth==7){
            visited = new boolean[7];
            bfs();
            return;
        }

        // 5로 나눈 몫이 행, 나머지가 열 -> 5*5 행렬
        for(int i=st;i<25;i++){
            selected[depth] = i;
            if(arr[i/5][i%5].equals("Y")){
                search(depth+1,numY+1, i+1);
            }else{
                search(depth+1,numY, i+1);
            }
        }
    }

    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{selected[0]/5,selected[0]%5});
        visited[0] = true;
        int conn = 1; // 몇 개 연결되는지

        while(!q.isEmpty()){
            int[] tmp = q.remove();
            for(int i=0;i<4;i++){
                int nx = tmp[0]+dx[i];
                int ny = tmp[1]+dy[i];
                int ni = nx*5 + ny; //0~24로 표현되는 다음 idx
                if(nx>=0&&ny>=0&&nx<5&&ny<5){
                    for(int j=0;j<7;j++){
                        if(!visited[j]&&selected[j]==ni){
                            q.add(new int[]{nx,ny});
                            visited[j] = true;
                            conn++;
                        }
                    }

                }
            }
        }
        if(conn==7) cnt++;
    }
}