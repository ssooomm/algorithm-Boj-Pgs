import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res=0;
        
        while(n>=0){
            if(n%5==0){
                res+=n/5;
                System.out.println(res);
                return;
            }
            n-=3;
            res++;
        }
        System.out.println(-1);
        return;
    }
}