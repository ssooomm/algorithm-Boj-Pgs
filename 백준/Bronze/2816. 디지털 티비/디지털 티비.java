import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        int p1=0,p2=0;
        for(int i=0;i<n;i++){
            arr[i] = sc.next();
            if(arr[i].equals("KBS1")) p1=i;
            else if(arr[i].equals("KBS2")) p2=i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<p1;i++){
            sb.append("1");
        }
        for(int i=0;i<p1;i++){
            sb.append("4");
        }
        if(p1>p2)
            p2++;
        if(p2!=1){
            for(int i=0;i<p2;i++){
                sb.append("1");
            }
            for(int i=1;i<p2;i++){
                sb.append("4");
            }
        }
        System.out.println(sb);
    }
}