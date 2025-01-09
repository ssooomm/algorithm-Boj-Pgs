import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
        }
        Arrays.sort(arr, (e1,e2)->{
            if(e1[1]==e2[1]) return e1[0] - e2[0];
            else return e1[1] - e2[1]; 
        });
        for(int i=0;i<n;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
}