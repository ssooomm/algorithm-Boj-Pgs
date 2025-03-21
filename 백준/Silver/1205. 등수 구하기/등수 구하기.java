import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int score = sc.nextInt();
        int p = sc.nextInt(); //랭킹에 올라갈 수 있는 점수 개수
        int ans=-1;
        Integer[] arr = new Integer[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        //Arrays.sort(arr, Collections.reverseOrder());
        
        if(n==p && score <= arr[n-1])
            System.out.println(ans);
        else{
            ans=1;
            for(int i=0;i<n;i++){
                if(score<arr[i]) ans++;
                else break;
            }
            System.out.println(ans);
        }
    }
}