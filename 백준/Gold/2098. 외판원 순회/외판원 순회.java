import java.util.*;
import java.io.*;

public class Main{
    static int n, fullbit;
    static int INF = 1000000000; //오버헤드 방지
    static int[][] w;
    static int[][] dp;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        fullbit = (1<<n) -1; //모두 방문 상태로 비트 표시 
        w = new int[n][n]; //도시 간의 거리 저장 
        dp = new int[n][fullbit]; //상태 저장용 
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //어디서 시작하든 모든 노드 방문 
        System.out.println(tsp(0,1)); //0번 도시부터 탐색 시작 
    }
    
    static int tsp(int x, int check){ //check - 지금까지 방문한 도시 상태 
        //모든 도시 방문 완료
        if(check==fullbit){
            if(w[x][0]==0) return INF; //경로 없음 -> 탐색 무효화
            return w[x][0]; //경로 있음 
        }
        //이미 방문한 도시
        if(dp[x][check]!= -1) return dp[x][check];
        
        //해당 도시에 출석
        dp[x][check] = INF;
        
        //방문하지 않은 도시 탐색
        for(int i=0;i<n;i++){
            int next = check | (1<<i); //i번 도시 방문
            //경로 없거나 i번 도시 이미 방문한거면
            if(w[x][i]==0 || (check&(1<<i))!=0) continue;
            
            dp[x][check] = Math.min(dp[x][check], tsp(i,next)+w[x][i]);
        }
        return dp[x][check];
    }
}