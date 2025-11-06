import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for(int i=1;i<=n;i++){
            for(int x=0;x<i;x++){
                sb.append("*");
            }
            for(int y=2*(n-i);y>0;y--){
                sb.append(" ");
            }
            for(int x=0;x<i;x++){
                sb.append("*");
            }
            sb.append("\n");
        }
        for(int i=n-1;i>0;i--){
            for(int x=0;x<i;x++){
                sb.append("*");
            }
            for(int y=2*(n-i);y>0;y--){
                sb.append(" ");
            }
            for(int x=0;x<i;x++){
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}