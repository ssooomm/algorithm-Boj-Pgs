import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        bt(1);
        System.out.println(sb);
    }
    
    static void bt(int st){
        if(list.size()==m){
            for(int i:list){
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=st;i<=n;i++){
            list.add(i);
            bt(i+1);
            list.remove(list.size()-1);
        }
    }
}