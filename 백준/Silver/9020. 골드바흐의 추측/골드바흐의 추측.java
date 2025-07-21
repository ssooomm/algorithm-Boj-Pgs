import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-->0){
            int n = sc.nextInt();
            int tmp = n/2;
            for(int i=tmp;i>=2;i--){
                int j = n-i;
                if(prime(i)&&prime(j)){
                    System.out.println(i+" "+j);
                    break;
                }
            }
        }
    }
    
    static boolean prime(int n){
        if(n<=1) return false;
        if(n==2) return true;
        int tmp = (int)Math.sqrt(n);
        for(int i=2;i<=tmp;i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
