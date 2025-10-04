import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i=n;i>0;i--){
            for(int k=1;k<=i;k++){
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}