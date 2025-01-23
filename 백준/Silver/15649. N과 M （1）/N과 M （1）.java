import java.util.*;

public class Main{
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        boolean[] visited = new boolean[n+1];
        backtrack(n,m,new ArrayList<>(), visited);
        
        StringBuilder sb = new StringBuilder();
        for(List<Integer> list: res){
            for(int i=0;i<m;i++){
                sb.append(list.get(i)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static void backtrack(int n, int m, List<Integer> list, boolean[] visited){
        if(list.size()==m){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                list.add(i);
                visited[i] = true;
                backtrack(n,m,list,visited);
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}