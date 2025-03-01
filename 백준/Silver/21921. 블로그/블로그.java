import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        
        int st=0, end=x, sum=0;
        for(int i=0;i<x;i++){
            sum+=arr[i];
        }
        int max=sum, cnt=1;
        while(end<n){
            sum-=arr[st++];
            sum+=arr[end++];
            if(max==sum) cnt++;
            else if(max<sum){
                max = sum;
                cnt=1;
            }
        }
        if(max==0) System.out.println("SAD");
        else{
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}