import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static boolean[] v;
    static int[] marr;
    static int[][] arr;
    static int cost = Integer.MAX_VALUE;
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        v = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        marr = new int[4];
        for(int i=0;i<4;i++){
            marr[i] = Integer.parseInt(st.nextToken());
        }
        
        arr = new int[n][5];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int[] dp = new int[5];
        for(int i=1;i<=n;i++){
            bt(new ArrayList<>(), i, 0);
        }
        
        if(cost==Integer.MAX_VALUE) System.out.println(-1);
        else{
            System.out.println(cost);
            for(int i:ans){
                System.out.print((i+1)+" ");
            }
        }
    }
    
    // 사전 순 비교 함수
    static boolean dict(List<Integer> list1, List<Integer> list2){
        int len = Math.min(list1.size(),list2.size());
        for (int i = 0; i < len; i++) {
            if (list1.get(i) < list2.get(i)) return true; //교체
            if (list1.get(i) > list2.get(i)) return false;
        }
        return list1.size() < list2.size(); //(1,2) (1,2,3)
    }

    static void bt(List<Integer> list,int cnt,int st){
        if(list.size()==cnt){
            int[] dp = new int[5];
            for(int l:list){
                for(int i=0;i<5;i++){
                    dp[i]+=arr[l][i];
                }
            }
            for(int i=0;i<4;i++){
                if(dp[i]<marr[i]) return;
            }
            if(cost>dp[4]){
                cost = dp[4];
                ans = new ArrayList<>(list);
            }else if(cost==dp[4]){//사전 순
                if(dict(list,ans)){
                    ans = new ArrayList<>(list);
                }
            }
            return;
        }
        for(int i=st;i<n;i++){
            list.add(i);
            bt(list,cnt,i+1);
            list.remove(list.size()-1);
        }
    }
}