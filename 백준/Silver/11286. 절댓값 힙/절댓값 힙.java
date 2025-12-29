import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(
        (a,b)-> {
            int aa = Math.abs(a);
            int bb = Math.abs(b);
            if(aa!=bb){
                return aa-bb;
            }else{
                return a-b;
            }
        });
        
        while(n-->0){
            int x = sc.nextInt();
            if(x==0){
                if(pq.isEmpty()) System.out.println(0);
                else System.out.println(pq.poll());
            }else{
                pq.add(x);
            }
        }
    }
}