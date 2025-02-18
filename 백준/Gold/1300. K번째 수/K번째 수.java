import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int left = 1;
        int right = k;
        
        while(left<right){
            int mid = (left+right)/2;
            int cnt = 0;
            
            for(int i=1;i<=n;i++){
                cnt += Math.min(mid/i,n); //각 행의 원소의 개수가 n을 넘지 않음
            }
            
            if(k<=cnt) right = mid;
            else left = mid+1;
        }
        
        System.out.println(left);
    }
}