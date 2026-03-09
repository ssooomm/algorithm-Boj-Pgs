import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int[] arr = new int[h];
        int[] arr1 = new int[h];
        int[] arr2 = new int[h];
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(i%2==0){
                arr1[h-x]++;
            }else{
                arr2[x-1]++;
            }
        }
        for(int i=1;i<h;i++){
            arr1[i]+=arr1[i-1];
        }
        for(int i=h-2;i>=0;i--){
            arr2[i]+=arr2[i+1];
        }
        
        int min = Integer.MAX_VALUE,cnt=0;
        for(int i=0;i<h;i++){
            arr[i]=arr1[i]+arr2[i];
            if(arr[i]<min){
                min=arr[i];
                cnt=1;
            }else if(arr[i]==min){
                cnt++;
            }
        }
        
        System.out.println(min+" "+cnt);
        
    }
}