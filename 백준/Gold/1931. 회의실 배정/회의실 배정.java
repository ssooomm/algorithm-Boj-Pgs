import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        Queue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
            else return Integer.compare(a[1],b[1]);
        });
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b});
        }
        
        int cnt=1;
        int next = pq.poll()[1];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0]>=next){
                next = cur[1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}