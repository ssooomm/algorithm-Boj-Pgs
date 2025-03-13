import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            Arrays.sort(arr);
            if(arr[2]==0) return;
            if(arr[2]>=arr[0]+arr[1]){
                System.out.println("Invalid");
                continue;
            }
            if(arr[0]==arr[2]){
                System.out.println("Equilateral");
            }
            else if(arr[0]==arr[1]||arr[1]==arr[2]){
                System.out.println("Isosceles");
            }
            else{
                System.out.println("Scalene");
            }
        }
    }
}