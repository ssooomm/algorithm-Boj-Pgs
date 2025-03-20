import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        char[][] arr= new char[n][n];

        boolean flag = true;
        int x=0,y=0;
        for(int i=0;i<n;i++){
            char[] ch = br.readLine().toCharArray();
            for(int j=0;j<n;j++){
                arr[i][j] = ch[j];
                if(ch[j]=='*'&&flag){
                    flag = false;
                    x=i+1;
                    y=j;
                }
            }
        }
        sb.append((x+1)+" "+(y+1)+"\n");

        int cnt=0;
        for(int i=y-1;i>=0;i--){
            if(arr[x][i]=='*') cnt++;
            else break;
        }
        sb.append(cnt+" ");

        cnt=0;
        for(int i=y+1;i<n;i++){
            if(arr[x][i]=='*') cnt++;
            else break;
        }
        sb.append(cnt+" ");

        cnt=0;
        int end = 0;
        for(int j=x+1;j<n;j++){
            if(arr[j][y]=='*') cnt++;
            else{
                end = j;
                break;
            }
        }
        sb.append(cnt+" ");

        cnt=0;
        for(int j=end;j<n;j++){
            if(arr[j][y-1]=='*') cnt++;
            else break;
        }
        sb.append(cnt+" ");

        cnt=0;
        for(int j=end;j<n;j++){
            if(arr[j][y+1]=='*') cnt++;
            else break;
        }
        sb.append(cnt+" ");

        System.out.println(sb);
    }
}