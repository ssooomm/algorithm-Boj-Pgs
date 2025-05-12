import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();
        
        int n = a.length;
        int m = b.length;
        int[][] dp = new int[n+1][m+1];
        Arrays.fill(dp[0],0);
        for(int i=1;i<=n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1]){ //문자 일치
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{ //문자 불일치
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        int i=n,j=m;
        while(i>0&&j>0){
            if(a[i-1]==b[j-1]){
                stack.push(a[i-1]);
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]) i--;
                else j--;
            }
        }
        
        sb.append(stack.size()+"\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        
        System.out.println(sb);
    }
}