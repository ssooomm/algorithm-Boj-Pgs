import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long min = 1000000001;
        Queue<long[]> pq = new PriorityQueue<>((x,y)->Long.compare(y[0],x[0]));
        pq.add(new long[]{a,1});
        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            if(cur[0]==b){
                min = Math.min(cur[1],min);
            }else{
                long x = cur[0]*2;
                if(x<=b){
                    pq.add(new long[]{x,cur[1]+1});
                }
                long y = cur[0]*10 + 1;
                if(y<=b){
                    pq.add(new long[]{y,cur[1]+1});
                }
            }
        }
        System.out.println(min==1000000001?-1:min);
        return;
    }
}