
import java.util.*;
import java.io.*;

public class Main{
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] ans = new int[n+1];
        // 0~9까지 어떤 숫자 썼는지 알기
        boolean[] visited = new boolean[10];

        dfs("",0, n, visited, arr);
        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));

    }

    // (리턴받을 문자열, 인덱스)
    static void dfs(String num, int idx,int n, boolean[] visited, String[] arr){
        // 부등호 끝까지 도달
        if(idx==n+1){
            // 부등호 성립되는 모든 경우의 수 저장
            list.add(num);
            return;
        }

        // 0~9까지
        for(int i=0;i<10;i++){
            if(!visited[i]){
                if(idx==0 || check(num.charAt(idx-1)-'0',i,arr[idx-1])){
                    visited[i] = true;
                    dfs(num+i, idx+1, n, visited, arr);
                    visited[i] = false;
                }
            }
        }
    }

    static boolean check(int e1, int e2, String str){
        if(str.equals(">")){
            if(e1<e2) return false;
        }
        else if(str.equals("<")){
            if(e1>e2) return false;
        }
        return true;
    }
}