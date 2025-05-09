import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = gcd(a,b);
        
        System.out.println(m);
        System.out.println(a*b/m);
    }
    static int gcd(int a, int b){
        int m = a%b;
        if(m==0) return b;
        return gcd(b,m);
    }
}