import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][2];
        int[] ans = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<n;i++){
            int x = arr[i][0];
            int y = arr[i][1];
            int cnt = 1;
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(arr[j][0]>x && arr[j][1]>y){
                    cnt++;
                }
            }
            sb.append(cnt+" ");
        }
        
        System.out.println(sb);
    }
}