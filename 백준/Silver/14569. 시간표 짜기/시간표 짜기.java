import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] timetable = new long[1001];
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j=0;j<k;j++){
                int time = Integer.parseInt(st.nextToken());
                timetable[i] |= (1L<<time);
            }
        }
        int m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            long tmp=0;
            for(int j=0;j<size;j++){
                int time = Integer.parseInt(st.nextToken());
                tmp |= (1L<<time);
            }
            tmp = ~tmp; //not 연산 적용
            
            int cnt=0;
            for(int j=0;j<n;j++){
                if((tmp & timetable[j])==0){ //and 연산
                    cnt++;
                }
            }
            sb.append(cnt+"\n");
            
        }
        System.out.println(sb);
    }
}