import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        // 집중국이 센서보다 수가 많으면 거리는 무조건 0
        if(N<=K){
            System.out.println(0);
            return;
        }
        
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        int[] diff = new int[N];
        for(int i=1,j=0;i<N;i++,j++){
            diff[j] = arr[i] - arr[i-1];
        }
        Arrays.sort(diff);
        int min = 0;
        for(int i=0;i<=N-K;i++){
            min+=diff[i];
        }
        System.out.println(min);
    }
}