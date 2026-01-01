import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        for(int i=m;i<=n;i++){
            if(isPrime(i)) System.out.println(i);
        }
    }
    
    static boolean isPrime(int x){
        if(x==1) return false;

        int sq = (int)Math.sqrt(x);
        for(int i=2;i<=sq;i++){
            if(x%i==0) return false;
        }
        return true;
    }
}