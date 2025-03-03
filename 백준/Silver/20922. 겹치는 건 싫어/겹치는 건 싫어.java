import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer strt = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(strt.nextToken());
        int k = Integer.parseInt(strt.nextToken());
        int[] arr = new int[n];
        strt = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(strt.nextToken());
        }

        Map<Integer,Integer> map = new HashMap<>();
        int st=0, end=0, max=0;
        while(st<n){
            while(end<n){
                int cnt = map.getOrDefault(arr[end],0);
                if(cnt<k){
                    map.put(arr[end],cnt+1);
                }
                else break;
                end++;
            }
            
            max = Math.max(end-st,max);
            map.put(arr[st],map.get(arr[st])-1);
            st++;
        }
        
        System.out.println(max);
    }
}