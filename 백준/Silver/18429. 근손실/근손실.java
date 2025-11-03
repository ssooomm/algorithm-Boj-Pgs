import java.util.*;

public class Main{
    static int n, k, res=0;
    static int[] arr;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        bt();
        
        System.out.println(res);
    }
    
    static void bt(){
        if(list.size()==n){
            if(check()){
                res++;
            }
            return;
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                list.add(i);
                bt();
                visited[i] = false;
                list.remove(list.size()-1);
            }
           
        }
    }
    
    static boolean check(){
        int x=500;
        for(int i:list){
            x=x-k+arr[i];
            if(x<500) return false;
        }
        return true;
    }
    
}