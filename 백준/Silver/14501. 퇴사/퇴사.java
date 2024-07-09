import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+1];
        int[] P = new int[N+1];
        int[] dp = new int[N+2];
        StringTokenizer st;
        for(int i = 1; i <= N; i++){
           st = new StringTokenizer(br.readLine());
           T[i] = Integer.parseInt(st.nextToken());
           P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N;i>0;i--){
            int next = i+T[i];

            if(next > N+1){
                dp[i] = dp[i + 1];
            }else{
                dp[i] = Math.max(dp[i+1], P[i]+dp[next]);
            }
        }

        System.out.println(dp[1]);
    }
}