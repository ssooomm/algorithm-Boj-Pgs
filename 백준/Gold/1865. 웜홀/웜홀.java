import java.util.*;
import java.io.*;

public class Main{
    static int[] dist;
    static int n;
    static List<List<int[]>> list;
    static int INF = 10000000;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            dist = new int[n+1];
            for(int i=0;i<=n;i++){
                list.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list.get(s).add(new int[]{e,t});
                list.get(e).add(new int[]{s,t});
            }
            for(int i=0;i<w;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken())*(-1);
                list.get(s).add(new int[]{e,t});
            }
            
            boolean flag = false;
            for(int i=1;i<=n;i++){
                if(bf(i)){
                    flag = true;
                    break;
                }
            }
            
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
        
        
    }
    
    public static boolean bf(int st){
        Arrays.fill(dist,INF);
        dist[st] = 0;
        boolean flag = false;
        
        for(int x=1;x<n;x++){
            flag = false;
            for(int i=1;i<=n;i++){
                for(int[] arr:list.get(i)){
                    int next = arr[0];
                    int cost = arr[1];
                    if(dist[i]==INF) continue;
                    if(dist[next]>(dist[i]+cost)){
                        dist[next] = dist[i]+cost;
                        //i번째에서 값 갱신 
                        flag = true;
                    }
                }
            }
            if(!flag)
                break;
        }
        if(flag){
            for(int i=1;i<=n;i++){
                for(int[] l:list.get(i)){
                    if(dist[i]!=INF && dist[l[0]]>dist[i]+l[1]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}