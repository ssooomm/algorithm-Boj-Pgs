import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String[] arr = sc.next().split("");
        boolean[] flag = new boolean[n];
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(arr[i].equals("P")){
                for(int j=i-k;j<=i+k;j++){
                    if(j<0) continue;
                    if(j>=n) break;
                    if(arr[j].equals("H")&&!flag[j]){
                        flag[j] = true;
                        break;
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            if(flag[i]) cnt++;
        }
        System.out.println(cnt);
    }
}