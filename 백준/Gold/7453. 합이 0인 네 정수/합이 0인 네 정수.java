import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr= new int[n][4];
        StringTokenizer st;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }
        
        long[] g1 = new long[n*n];
        long[] g2 = new long[n*n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                g1[i*n+j] = arr[i][0]+arr[j][1];
                g2[i*n+j] = arr[i][2]+arr[j][3];
            }
        }
        
        Arrays.sort(g1);
        Arrays.sort(g2);
        
        int l = 0;
        int r = n*n-1;
        
        long res=0;
        while(l<n*n&&r>=0){
            if(g1[l]+g2[r]==0){
                long x = g1[l];
                long y = g2[r];

                long xcnt=0,ycnt=0;
                while(l<n*n && g1[l]==x){
                    xcnt++;
                    l++;
                }
                while(r>=0&&g2[r]==y){
                    ycnt++;
                    r--;
                }
                res+=xcnt*ycnt;

            }else if(g1[l]+g2[r]<0){
                l++;
            }else{
                r--;
            }
            
        }
        System.out.println(res);
    }
}