import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        String ans = sc.next();
        if(a.contains(ans)&&b.contains(ans)) System.out.println("YES");
        else System.out.println("NO");
    }
}