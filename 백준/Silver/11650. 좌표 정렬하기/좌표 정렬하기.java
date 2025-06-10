import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Queue<int[]> pq = new PriorityQueue<>((x,y)->{
            if(x[0]!=y[0]) return Integer.compare(x[0],y[0]);
            else return Integer.compare(x[1],y[1]);
        });
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pq.add(new int[]{x,y});
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            sb.append(cur[0]+" "+cur[1]+"\n");
        }
        System.out.println(sb);
    }
}