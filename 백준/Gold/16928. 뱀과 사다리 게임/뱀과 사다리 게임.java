import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] dp = new int[101];
        for(int i=1;i<=100;i++) dp[i]= i;
        
        for(int i=0;i<n+m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            dp[a] = b;
        }
        
        System.out.println(bfs(dp));
    }
    static int bfs(int[] dp){
        int[] cnt = new int[101]; //주사위 횟수
        boolean[] v = new boolean[101];
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(1); //1번째 칸
        v[1] = true;
        
        while(!q.isEmpty()){
            int tmp = q.poll();
            if(tmp==100) return cnt[100];
            
            for(int i=1;i<=6;i++){
                int next = tmp+i;
                if(next>100) break;
                
                int newn = dp[next];
                
                if(!v[newn]){
                    v[newn] = true;
                    cnt[newn] = cnt[tmp]+1;
                    q.add(newn);
                }
            }
            
        }
        return -1;
    }
   
}