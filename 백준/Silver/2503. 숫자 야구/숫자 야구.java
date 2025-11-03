import java.util.*;
import java.io.*;

public class Main{
    static Queue<List<Integer>> q = new ArrayDeque<>();
    static List<Integer> tmp = new ArrayList<>();
    static boolean[] visited = new boolean[10];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        int[] s = new int[n];
        int[] b = new int[n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j=0;j<3;j++){
                arr[i][j] = str.charAt(j)-'0';
            }
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        bt();
        
        int res=0;
        while(!q.isEmpty()){
            List<Integer> tmp = q.poll();
            boolean flag = false;
            for(int i=0;i<n;i++){
                int tmps=0, tmpb=0;
                
                if(tmp.get(0)==arr[i][0]){
                    tmps++;
                }else{
                    if(tmp.get(0)==arr[i][1]||tmp.get(0)==arr[i][2]) tmpb++;
                }
                
                if(tmp.get(1)==arr[i][1]){
                    tmps++;
                }else{
                    if(tmp.get(1)==arr[i][0]||tmp.get(1)==arr[i][2]) tmpb++;
                }
                
                if(tmp.get(2)==arr[i][2]){
                    tmps++;
                }else{
                    if(tmp.get(2)==arr[i][0]||tmp.get(2)==arr[i][1]) tmpb++;
                }
                
                if(tmps!=s[i]||tmpb!=b[i]){
                    flag = true;
                    break;
                }
            }
            if(!flag)
                res++;
        }
        
        System.out.println(res);
    }
    
    static void bt(){
        if(tmp.size()==3){
            // tmp 복사해서 넣어줘야 함!
            q.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=1;i<=9;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(i);
                bt();
                visited[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}