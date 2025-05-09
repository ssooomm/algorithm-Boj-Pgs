import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = gcd(a,b);
        
        int ma = a/m;
        int mb = b/m;
        System.out.println(m);
        System.out.println(m*ma*mb);
    }
    static int gcd(int a, int b){
        int m = a%b;
        if(m==0) return b;
        return gcd(b,m);
    }
}