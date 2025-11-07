import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static List<Integer> list = new ArrayList<>();
    static boolean[] v;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = new boolean[n+1];
        
        bt();
        System.out.println(sb);
    }
    
    static void bt(){
        if(list.size()==m){
            for(int i:list){
                sb.append(i+" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(!v[i]){
                v[i] = true;
                list.add(i);
                bt();
                v[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}