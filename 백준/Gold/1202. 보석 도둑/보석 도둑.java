import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new int[]{m,v});
        }
        int[] bag = new int[k];
        for(int i=0;i<k;i++){
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);
        
        long sum=0;
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<k;i++){
            while(!pq.isEmpty()&&pq.peek()[0]<=bag[i]){
                pq2.add(pq.poll()[1]);
            }
            if(!pq2.isEmpty())
                sum+=pq2.poll();
        }
        System.out.println(sum);
    }
}