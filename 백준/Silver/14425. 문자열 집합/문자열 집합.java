import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(sc.next(),0);
        }
        int cnt = 0;
        for(int i=0;i<m;i++){
            if(map.containsKey(sc.next())) cnt++;
        }
        System.out.println(cnt);
    }
}