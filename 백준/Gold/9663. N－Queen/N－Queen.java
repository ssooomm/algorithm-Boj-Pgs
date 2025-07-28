import java.util.*;

public class Main{
    static int n,res=0;
    static int[] arr;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        
        bt(0);
        System.out.println(res);
    }
    
    static void bt(int depth){
        if(depth==n){
            res++;
            return;
        }
        for(int i=0;i<n;i++){
            arr[depth] = i;
            if(possible(depth)){
                bt(depth+1);
            }
        }
    }
    
    static boolean possible(int col){
        for(int i=0;i<col;i++){
            if(arr[col]==arr[i]) return false;
            else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])) return false;
        }
        return true;
    }
}