import java.io.*;
import java.util.*;

public class Main{
    static List<String> list = new ArrayList<>();
    static int n;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        
        boolean[] visited = new boolean[10];
        
        dfs("",0,visited,arr);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));
        
    }
    
    static void dfs(String num, int idx, boolean[] visited, String[] arr){
        if(num.length()==n+1){
            list.add(num);
            return;
        }
        for(int i=0;i<10;i++){
            if(!visited[i]){
                if(idx==0||check(num.charAt(idx-1)-'0',i,arr[idx-1])){
                    visited[i] = true;
                    dfs(num+i,idx+1,visited,arr);
                    visited[i] = false;
                }
            }
            
        }
    }
    
    static boolean check(int e1, int e2, String str){
        if(str.equals(">")){
            if(e1<e2) return false;
        }
        else if(str.equals("<")){
            if(e1>e2) return false;
        }
        return true;
    }
}