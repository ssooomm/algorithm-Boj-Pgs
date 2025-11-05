import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int cnt=1;
        for(int x=0;x<n;x++){
            for(int j=0;j<x;j++){
                sb.append(" ");
            }
            for(int i=0;i<2*n-cnt;i++){
                sb.append("*");
            }
            cnt+=2;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}