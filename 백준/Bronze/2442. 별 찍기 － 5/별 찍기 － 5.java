import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int last = 2*n-1;
        for(int i=1;i<=n;i++){
            int l = 2*i-1;
            int sp = (last-l)/2;
            int idx=0;
            for(;idx<sp;idx++){
                sb.append(" ");
            }
            for(;idx<sp+l;idx++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}