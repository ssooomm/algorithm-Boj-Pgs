import java.util.*;
import java.io.*;

public class Main{
    static int[] arr;
    static int[] tree;
    static int n;
    
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        tree = new int[n*4];
        init(1,1,n);
        
        StringBuilder sb = new StringBuilder();
        int m= Integer.parseInt(br.readLine());
        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num==1){
                int idx = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[idx] = v;
                update(1,1,n,idx);
            }else{
                sb.append(tree[1]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    
    public static int get(int i,int j){
        if(i==-1) return j;
        if(j==-1) return i;
        
        if(arr[i]<arr[j]) return i;
        else if(arr[j]<arr[i]) return j;
        else return Math.min(i,j);
    }
    
    public static void init(int node, int start, int end){
        if(start==end){
            tree[node] = start;
            return;
        }
        int mid = (start+end)/2;
        init(node*2,start,mid);
        init(node*2+1, mid+1, end);
        
        tree[node] = get(tree[node*2], tree[node*2+1]);
    }
    
    public static void update(int node, int st, int end, int idx){
        if(idx<st||idx>end) return;
        if(st==end) return;
        
        int mid = (st+end)/2;
        update(node*2,st,mid,idx);
        update(node*2+1,mid+1,end,idx);
        tree[node] = get(tree[node*2],tree[node*2+1]);
        
    }
    
        
}