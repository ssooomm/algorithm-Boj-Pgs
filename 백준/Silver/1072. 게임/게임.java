import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();
        long y = sc.nextInt();
        long z = y*100/x;
        
        long l = 1;
        long r = x+1;
        while(l<r){
            long mid = (l+r)/2;
            long tmp = (y+mid)*100/(x+mid);
            if(tmp>z){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        if(l>x) System.out.println("-1");
        else System.out.println(l);
        
    }
}