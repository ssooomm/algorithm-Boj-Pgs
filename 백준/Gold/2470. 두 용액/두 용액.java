import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new PriorityQueue<>((a,b)->Math.abs(a)-Math.abs(b));
        while(n-->0){
            q.add(Integer.parseInt(st.nextToken()));
        }
        
        int min = Integer.MAX_VALUE;
        int[] arr = new int[2];
        int before = q.poll();
        while(!q.isEmpty()){
            int cur = q.poll();
            int tmp = Math.abs(before+cur);
            if(min>tmp){
                min=tmp;
                arr[0]=before;
                arr[1]=cur;
            }
            before=cur;
        }
        Arrays.sort(arr);
        System.out.println(arr[0]+" "+arr[1]);
    }
}