import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        Queue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b});
        }
        int cnt=0,i=0;
        while(!pq.isEmpty()){
            int[] x = pq.poll();
            if(i<x[0]) i=x[0];
            for(;i<x[1];i+=l){
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }
}