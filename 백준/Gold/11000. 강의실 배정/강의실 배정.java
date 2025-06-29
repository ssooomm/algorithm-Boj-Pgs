import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b});
        }
        Queue<Integer> end = new PriorityQueue<>();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(!end.isEmpty()&&end.peek()<=cur[0]){
                end.poll();
            }
            end.add(cur[1]);
        }
        System.out.println(end.size());
    }
}