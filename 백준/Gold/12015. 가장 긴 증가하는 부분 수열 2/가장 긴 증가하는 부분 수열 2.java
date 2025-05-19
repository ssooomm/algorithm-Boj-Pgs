import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        list.add(arr[0]);
        
        for(int i=1;i<n;i++){
            if(list.get(list.size()-1)<arr[i]) list.add(arr[i]);
            else{ //이분 탐색 진행
                int start=0;
                int end = list.size()-1;
                while(start<end){
                    int mid = (start+end)/2;
                    if(list.get(mid)>=arr[i]) end = mid;
                    else start = mid+1;
                }
                list.set(end,arr[i]);
            }
        }
        System.out.println(list.size());
    }
}