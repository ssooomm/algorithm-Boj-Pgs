import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        if(n<3){
            System.out.println(1);
            return;
        }
        
        int cnt = 1, st=1,end=2,sum=3;
        
        while(st<end){
            if(sum==n){
                cnt++;
                sum-=st;
                st++;
            }
            while(sum>n){
                sum-=st;
                st++;
            }
            while(sum<n){
                end++;
                sum+=end;
            }
        }
        System.out.println(cnt);
    }
}