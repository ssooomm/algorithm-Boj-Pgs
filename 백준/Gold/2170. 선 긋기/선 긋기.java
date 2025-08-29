import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new int[]{x,y});
        }
        
        long res=0;
        int[] cur = pq.poll();
        int f = cur[0];
        int l = cur[1];
        while(!pq.isEmpty()){
            cur = pq.poll();
            if(cur[0]<=l){
                l=Math.max(l,cur[1]);
            }else{
                res += l-f;
                f = cur[0];
                l = cur[1];
            }
        }
        res+=l-f;
        
        System.out.println(res);       
    }
}