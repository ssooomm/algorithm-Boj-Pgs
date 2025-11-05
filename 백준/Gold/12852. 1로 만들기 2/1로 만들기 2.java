import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        Arrays.fill(arr,1000000);
        int[] idx = new int[n+1];
        arr[n] = 0;
        idx[n] = n;
        if(n==1){
            System.out.println(0);
            System.out.println(1);
            return;
        }
        
        for(int i=n;i>0;i--){
            int ncnt = arr[i]+1;
            if(arr[i-1]>ncnt){
                arr[i-1] = ncnt;
                idx[i-1] = i;
            }
            
            if(i%3==0){
                if(arr[i/3]>ncnt){
                    arr[i/3] = ncnt;
                    idx[i/3] = i;
                }
            }
            
            if(i%2==0){
                if(arr[i/2]>ncnt){
                    arr[i/2] = ncnt;
                    idx[i/2] = i;
                }
            }
            
        }
        StringBuilder sb = new StringBuilder();
        sb.append(arr[1]+"\n");
        
        List<Integer> list = new ArrayList<>();
        int i=1;
        while(true){
            list.add(i);
            i = idx[i];
            if(i==n){
                list.add(i);
                break;
            }
        }
        Collections.reverse(list);
        for(int x:list){
            sb.append(x+" ");
        }
        
        System.out.println(sb);
    }
}