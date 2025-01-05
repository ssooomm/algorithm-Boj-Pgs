import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        
        Arrays.sort(arr);
        double tmp=0;
        int cnt=0;
        for(int i=0;i<N;i++){
            if(tmp>arr[i]) continue;
            tmp = arr[i]+L-0.5;
            cnt++;
        }
        System.out.println(cnt);
    }
}