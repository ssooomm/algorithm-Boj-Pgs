import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rank = new int[n+1];
        int[] ans = new int[n+1];
        for(int i=1;i<=n;i++){
            rank[i] = sc.nextInt();
        }
        
        for(int i=1;i<=n;i++){
            int j=1;
            while(true){
                if(rank[i]==0&&ans[j]==0){
                    ans[j]=i;
                    break;
                }
                else if(ans[j]==0)
                    rank[i]--;
                j++;
            }
        }
        
        for(int i=1;i<=n;i++){
            System.out.print(ans[i]+" ");
        }
    }
}