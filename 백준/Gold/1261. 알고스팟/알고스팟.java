import java.util.*;

public class Main{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int[][] arr = new int[n][m];
        boolean[][] v = new boolean[n][m];
        for(int i=0;i<n;i++){
            String str = sc.next();
            for(int j=0;j<m;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
        }
        Queue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.add(new int[]{arr[0][0],0,0});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[1]==n-1&&cur[2]==m-1){
                System.out.println(cur[0]);
                return;
            }
            
            for(int i=0;i<4;i++){
                int nx = cur[1]+dx[i];
                int ny = cur[2]+dy[i];
                if(nx>=0&&nx<n&&ny>=0&&ny<m){
                    if(!v[nx][ny]){
                        v[nx][ny] = true;
                        pq.add(new int[]{cur[0]+arr[nx][ny],nx,ny});
                    }
                }
            }
            
        }
        
    }
}