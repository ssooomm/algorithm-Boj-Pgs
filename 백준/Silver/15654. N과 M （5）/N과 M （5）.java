import java.util.*;

public class Main{
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[] visited = new boolean[n];
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        backtrack(n,m,visited, arr, new ArrayList<>());
        
        StringBuilder sb = new StringBuilder();
        for(List<Integer> list:res){
            for(int i=0;i<m;i++){
                sb.append(list.get(i)+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static void backtrack(int n, int m, boolean[] visited, int[] arr, List<Integer> list){
        if(list.size()==m){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!visited[i]){
                list.add(arr[i]);
                visited[i] = true;
                backtrack(n,m,visited, arr, list);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}