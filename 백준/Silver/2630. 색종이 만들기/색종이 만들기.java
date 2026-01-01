import java.util.*;
import java.io.*;

public class Main{
    static int[][] arr;
    static int[] res = new int[2];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        check(0,0,n);
        
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
    
    static void check(int x,int y, int l){
        int ch = isCom(x,y,l);
        if(ch==-1){
            l/=2;
            check(x,y,l);
            check(x,y+l,l);
            check(x+l,y,l);
            check(x+l,y+l,l);
        }else{
            res[ch]++;
        }
    }
    
    static int isCom(int x, int y, int l){
        int tmp = arr[x][y];
        for(int i=x;i<x+l;i++){
            for(int j=y;j<y+l;j++){
                if(tmp!=arr[i][j]){
                    return -1;
                }
            }
        }
        return tmp;
    }
}