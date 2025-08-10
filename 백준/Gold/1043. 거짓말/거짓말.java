import java.util.*;
import java.io.*;

public class Main{
    static int[] parents;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
        
        parents = new int[n+1];
        for(int i=1;i<n+1;i++){
            parents[i]=i;
        }
        
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        if(num==0){
            System.out.println(m);
            return;
        }else{
            for(int i=0;i<num;i++){
                list.add(Integer.parseInt(st.nextToken()));
            }
        }
        
        List<List<Integer>> plist = new ArrayList<>();
        for(int i=0;i<m;i++){
            plist.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int pn = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            plist.get(i).add(x);
            for(int j=1;j<pn;j++){
                int y = Integer.parseInt(st.nextToken());
                union(x,y);
                plist.get(i).add(y);
            }
        }
        
        int cnt=0;
        for(int i=0;i<m;i++){
            boolean flag = true;
            for(int p:plist.get(i)){
                if(list.contains(find(parents[p]))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    static int find(int x){
        if(parents[x]==x) return x;
        return find(parents[x]);
    }
    
    static void union(int x, int y){
        int rx = find(x);
        int ry = find(y);
        
        if(list.contains(ry)){
            int tmp = rx;
            rx=ry;
            ry = tmp;
        }
        
        parents[ry] = rx;
    }
}