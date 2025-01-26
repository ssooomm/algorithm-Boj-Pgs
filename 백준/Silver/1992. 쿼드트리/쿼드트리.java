import java.io.*;
import java.util.*;

public class Main{
    static int[][] map;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        for(int i=0;i<n;i++){
            String[] tmp = br.readLine().split("");
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        
        quad(n,0,0);
        
        System.out.println(sb);
    }
    
    static void quad(int n,int x, int y){
        if(check(n,x,y)){
            sb.append(map[x][y]);
            return;
        }
        
        // 4가지로 쪼개기
        int sh = n/2;
        sb.append("(");
        quad(sh,x,y); // L위
        quad(sh,x,y+sh); // R위
        quad(sh,x+sh,y); // L아래
        quad(sh,x+sh,y+sh); // R아래
        sb.append(")");
    }
    
    static boolean check(int n, int x, int y){
        int tmp = map[x][y];
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(map[i][j]!=tmp){
                    return false;
                    
                }
            }
        }
        return true;
    }
}