import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] x = new int[3];
        int[] y = new int[3];
        for(int i=0;i<3;i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        
        StringBuilder sb = new StringBuilder();
        if(x[0]==x[1]) sb.append(x[2]+" ");
        else if(x[1]==x[2]) sb.append(x[0]+" ");
        else sb.append(x[1]+" ");
        
        if(y[0]==y[1]) sb.append(y[2]);
        else if(y[1]==y[2]) sb.append(y[0]);
        else sb.append(y[1]);
        
        System.out.println(sb);
    }
}