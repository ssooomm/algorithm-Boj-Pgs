import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i] = sc.nextInt();
        }

        int side = Math.max(arr[0],n-arr[m-1]);
        int max = 0;
        for(int i=1;i<m;i++){
            max = Math.max(arr[i]-arr[i-1],max);
        }
        
        System.out.println(Math.max(side,(max+1)/2));
    }
}