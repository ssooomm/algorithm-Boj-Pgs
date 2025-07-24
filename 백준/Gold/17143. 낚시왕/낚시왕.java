import java.util.*;
import java.io.*;

public class Main{
    static class Fish implements Comparable<Fish>{
        int x;
        int y;
        int s;
        int d;
        int z;
        public Fish(int x,int y,int s,int d,int z){
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
        
        @Override
        public int compareTo(Fish o){
            return o.z-this.z; //큰 상어 먼저 
        }
    }
    static int r,c;
    static Fish[][] map;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new Fish[r+1][c+1];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            map[x][y] = new Fish(x,y,s,d,z);
        }
        
        int res = 0;
        for(int i=1;i<=c;i++){
            for(int j=1;j<=r;j++){
                if(map[j][i]!=null){
                    res+=map[j][i].z;
                    map[j][i] = null;
                    break;
                }
            }
            move();
        }
        
        System.out.println(res);
    }
    
    static void move(){
        Queue<Fish> pq = new PriorityQueue<>();
        for(int i=1;i<=r;i++){
            for(int j=1;j<=c;j++){
                if(map[i][j]!=null){
                    Fish f = map[i][j];
                    pq.add(dir(f.x,f.y,f.s,f.d,f.z));
                }
            }
        }
        map = new Fish[r+1][c+1];
        while(!pq.isEmpty()){
            Fish f = pq.poll();
            if(map[f.x][f.y]==null||map[f.x][f.y].z<f.z){
                map[f.x][f.y] = f;
            }
        }
    }
    
   static Fish dir(int x, int y, int s, int d, int z) {
       int move = s;
       if (d <= 2) move %= (r - 1) * 2; 
       else move %= (c - 1) * 2; 

       int nx = x, ny = y, nd = d;

       while (move > 0) {
           if (nd == 1) { // 위로
               if (nx - move > 0) return new Fish(nx - move, ny, s, nd, z);
               move -= (nx - 1); // 벽까지 이동
               nx = 1;
               nd = 2; // 방향 반전
           } else if (nd == 2) { // 아래로
               if (nx + move <= r) return new Fish(nx + move, ny, s, nd, z);
               move -= (r - nx);
               nx = r;
               nd = 1;
           } else if (nd == 3) { // 오른쪽
               if (ny + move <= c) return new Fish(nx, ny + move, s, nd, z);
               move -= (c - ny);
               ny = c;
               nd = 4;
           } else { // 왼쪽
               if (ny - move > 0) return new Fish(nx, ny - move, s, nd, z);
               move -= (ny - 1);
               ny = 1;
               nd = 3;
           }
       }
       return new Fish(nx, ny, s, nd, z);
   }
}