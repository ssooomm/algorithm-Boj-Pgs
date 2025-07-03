import java.util.*;

public class Main{
    static int n,m;
    static StringBuilder res = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        backtrack(new ArrayList<>(), 1);
        System.out.println(res);
    }
    
    static void backtrack(List<Integer> list, int st){
        if(list.size()==m){
            for(int i:list){
                res.append(i+" ");
            }
            res.append("\n");
            return;
        }
        
        for(int i=st;i<=n;i++){
            list.add(i);
            backtrack(list,i);
            list.remove(list.size()-1);
        }
    }
}