import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int num=0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    num = num<<1;
                    // 앞면1, 뒷면0
                    if(sc.next().equals("H")){
                        num+=1;
                    }
                }
            }
            System.out.println(bfs(num));
        }
    }
    
    static int bfs(int num){
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[512]; //2^0 ~ 2^8
        visited[num] = true;
        q.add(new int[]{num,0});
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(tmp[0]==0||tmp[0]==511){
                return tmp[1];
            }
            
            // 행 뒤집기
            for(int i=0;i<3;i++){
                int next = tmp[0]^(448>>(3*i));
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next,tmp[1]+1});
                }
            }
            
            // 열 뒤집기
            for(int i=0;i<3;i++){
                int next = tmp[0]^(292>>(1*i));
                if(!visited[next]){
                    visited[next] = true;
                    q.add(new int[]{next,tmp[1]+1});
                }
            }
            
            //대각선 256+16+1
            int next1 = tmp[0]^273;  
            if(!visited[next1]){
                visited[next1] = true;
                q.add(new int[]{next1,tmp[1]+1});
            }
            
            //대각선 64+16+4
            int next2 = tmp[0]^84;  
            if(!visited[next2]){
                visited[next2] = true;
                q.add(new int[]{next2,tmp[1]+1});
            }
        }
        return -1;
    }
}