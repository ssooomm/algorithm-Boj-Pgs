import java.util.*;

public class Main{
    static StringBuilder res = new StringBuilder();
    static int n,m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        backtrack(new ArrayList<>());
        System.out.println(res);
    }
    static void backtrack(List<Integer> list){
        if(list.size()==m){
            for(int i:list){
                res.append(i+" ");
            }
            res.append("\n");
            return;
        }
        
        for(int i=1;i<=n;i++){
            list.add(i);
            backtrack(list);
            list.remove(list.size()-1);
        }
    }
}