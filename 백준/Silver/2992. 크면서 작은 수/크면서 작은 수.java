import java.util.*;
import java.io.*;

class Main {
    static int n,num;
    static int[] arr, list;
    static boolean[] v;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        num = Integer.parseInt(str);
        n = str.length();
        arr = new int[n];
        list = new int[n];
        v = new boolean[n];
        for(int i=0;i<n;i++){
            arr[i] = str.charAt(i)-'0';
        }
        bt(0);
        System.out.println(min==Integer.MAX_VALUE?0:min);
    }

    static void bt(int depth){
        if(depth==n){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++){
                sb.append(list[i]);
            }
            int tmp = Integer.parseInt(sb.toString());
            if(num<tmp) min = Math.min(tmp,min);
            return;
        }
        for(int i=0;i<n;i++){
            if(!v[i]){
                v[i] = true;
                list[depth] = arr[i];
                bt(depth+1);
                v[i] = false;
            }
        }
    }
}