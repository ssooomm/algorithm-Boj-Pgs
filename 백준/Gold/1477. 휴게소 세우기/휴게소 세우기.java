import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        
        int[] arr = new int[n+2]; //거리의 시작과 끝도 저장
        arr[0] = 0;
        arr[n+1] = l;
        for(int i=1;i<=n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        
        int left = 1;
        int right = l-1;
        
        while(left<=right){
            int mid = (left+right)/2;
            int sum = 0;
            
            for(int i=1;i<arr.length;i++){
                sum+=(arr[i]-arr[i-1]-1)/mid; //현재 휴게소 사이에 mid 기준으로 몇 개 설치할 수 있는지
            }
            
            if(sum>m) left = mid+1; //너무 많이 설치
            else right = mid-1; //추가 설치 필요
        }
        System.out.println(left);
    }
}