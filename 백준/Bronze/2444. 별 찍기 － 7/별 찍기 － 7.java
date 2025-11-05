import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int bl = n,pl=2;
        for(int i=0;i<n;i++){
            for(int j=1;j<bl;j++){
                sb.append(" ");
            }
            for(int k=1;k<pl;k++){
                sb.append("*");
            }
            sb.append("\n");
            bl--;
            pl+=2;
        }
        bl=2;
        pl=2*n-2;
        for(int i=0;i<n-1;i++){
            for(int j=1;j<bl;j++){
                sb.append(" ");
            }
            for(int k=1;k<pl;k++){
                sb.append("*");
            }
            sb.append("\n");
            bl++;
            pl-=2;
        }
        System.out.println(sb);
    }
}