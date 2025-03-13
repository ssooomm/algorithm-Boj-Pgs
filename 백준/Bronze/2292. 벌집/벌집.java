import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int sum=1, i=1;
        while(sum<n){
            sum+=6*i++;
        }
        System.out.println(i);
    }
}