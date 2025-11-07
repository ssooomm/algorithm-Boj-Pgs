import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        int st=1, end=arr[n-1]-arr[0];
        int res=0;
        while(st<=end){
            int mid = (st+end)/2;
            int cnt=1, idx=0;
            for(int i=1;i<n;i++){
                if(arr[i]-arr[idx]>=mid){
                    idx=i;
                    cnt++;
                }
            }
            
            if(cnt>=c){
                st = mid+1;
                res = Math.max(res,mid);
            }else{
                end = mid-1;
            }
        }
        System.out.println(res);
    }
}