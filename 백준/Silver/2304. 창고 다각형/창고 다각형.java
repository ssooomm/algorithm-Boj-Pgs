import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int start=Integer.MAX_VALUE;
        int end = 0;
        int[] arr = new int[1001]; //1~1000
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[l] = h;
            start = Math.min(start,l);
            end = Math.max(end,l);
        }
        //arr[2]=4,arr[4]=6
        //st=2, end=15
        
        Deque<Integer> stack = new ArrayDeque<>();
        int tmp = arr[start];
        for(int i=start+1;i<=end;i++){
            if(arr[i]<tmp){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty()){
                    arr[stack.pop()] = tmp;
                }
                tmp=arr[i];
            }
        }
        stack.clear();
        
        tmp = arr[end];
        for(int i=end-1;i>=start;i--){
            if(arr[i]<tmp){
                stack.push(i);
            }
            else{
                while(!stack.isEmpty()){
                    arr[stack.pop()] = tmp;
                }
                tmp=arr[i];
            }
        }
        
        int res=0;
        for(int i=start;i<=end;i++){
            res+=arr[i];
        }
        System.out.println(res);
    }
}