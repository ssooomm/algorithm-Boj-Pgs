import java.util.*;
import java.io.*;

public class Main{
    static int[][] arr;
    static int[] ans = new int[3];
    static int len;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[n][n];
        len = n;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0,0,n);

        System.out.println(ans[0]);
        System.out.println(ans[1]);
        System.out.println(ans[2]);
    }


    static void cut(int x, int y, int n){
        if(check(x,y,n)){
            ++ans[arr[x][y]+1];
            return;
        }
        int sh = n/3;
        for(int a=x;a<x+n;a+=sh){
            for(int b=y;b<y+n;b+=sh){
                cut(a,b,sh);
            }
        }


    }

    static boolean check(int x,int y, int n){
        int tmp = arr[x][y];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[x+i][y+j]!=tmp){
                    return false;
                }
            }
        }
        return true;
    }
}