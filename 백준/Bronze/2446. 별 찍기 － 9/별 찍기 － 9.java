import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for(int i=n;i>0;i--){
            for(int y=n-i;y>0;y--){
                sb.append(" ");
            }
            for(int x=1;x<2*i;x++){
                sb.append("*");
            }
            sb.append("\n");
        }

        for(int i=2;i<=n;i++){
            for(int y=n-i;y>0;y--){
                sb.append(" ");
            }
            for(int x=1;x<2*i;x++){
                sb.append("*");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}