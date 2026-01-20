import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[100001];
        Arrays.fill(arr,100001);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        arr[n]=0;
        int min = 100001, cnt=0;
        while(!q.isEmpty()){
            int x = q.poll();
            if(x==k){
                if(min>arr[x]){
                    min = arr[x];
                    cnt=1;
                }else if(min==arr[x]){
                    cnt++;
                }
            }
            
            if(x-1>=0){
                if(arr[x-1]>=arr[x]+1){
                    q.add(x-1);
                    arr[x-1] = arr[x]+1;
                }
            }
            if(x+1<=100000){
                if(arr[x+1]>=arr[x]+1){
                    q.add(x+1);
                    arr[x+1] = arr[x]+1;
                }
            }
            if(x*2<=100000){
                if(arr[x*2]>=arr[x]+1){
                    q.add(x*2);
                    arr[x*2] = arr[x]+1;
                }
            }

        }
        System.out.println(arr[k]);
        System.out.println(cnt);
    }
}