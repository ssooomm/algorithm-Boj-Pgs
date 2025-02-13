import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] arr = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        
        int m = sc.nextInt();
        Arrays.sort(arr);
        
        if(sum<=m){
            System.out.println(arr[n-1]);
            return;
        }
        
        int remain = m;
        for(int i=0;i<n;i++){
            int avg = remain / (n-i); // 남은 예산을 남은 인원으로 나눈게 상한값
            if(arr[i]<=avg){
                remain -= arr[i]; // 이 예산은 그대로
            }else{
                System.out.println(avg);
                return;
            }
        }
        
    }
}