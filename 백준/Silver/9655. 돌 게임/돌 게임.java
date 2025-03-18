import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = n/3;
        if(x%2==0){
            if(n%3==1) System.out.println("SK");
            else System.out.println("CY");
        }else{
            if(n%3==1) System.out.println("CY");
            else System.out.println("SK");
        }
    }
}