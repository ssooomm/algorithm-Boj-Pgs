import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n =  sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int g = gcds(arr);
        for(int i=1;i<=g;i++){
            if(g%i==0) sb.append(i+"\n");
        }
        System.out.println(sb);
    }
    static int gcds(int[] arr){
        int tmp = gcd(arr[0],arr[1]);
        if(arr.length==2) return tmp;
        return gcd(tmp,arr[2]);
    }

    static int gcd(int a, int b){
        int r = a%b;
        if(r==0) return b;
        return gcd(b,r);
    }
}