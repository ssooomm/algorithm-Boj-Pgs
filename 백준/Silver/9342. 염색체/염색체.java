import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String reg = "[A-F]?A+F+C+[A-F]?$";
        
        while(t-->0){
            if(sc.next().matches(reg))
                System.out.println("Infected!");
            else
                System.out.println("Good");
        }
    }
}