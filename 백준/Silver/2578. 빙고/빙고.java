import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 빙고판 완성
        int[][] bingo = new int[5][5];
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 부르는 숫자 저장
        int[] ans = new int[25];
        int idx = 0;
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                ans[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        int[] col = new int[5]; //5열
        int[] row = new int[5]; //5행
        int crs1 = 0; //대각선1
        int crs2 = 0; //대각선2
        int cnt = 0;
        for(int i=0;i<25;i++){
            int c=0,r=0, flag = 0;
            for(int x=0;x<5;x++){
                for(int y=0;y<5;y++){
                    if(ans[i]==bingo[x][y]){
                        c = ++col[y]; //y열 지워짐
                        r = ++row[x]; //x행 지워짐
                        if((x+y)==4) crs1++;
                        if(x==y) crs2++;
                        flag=1;
                        break;
                    }
                }
                if(flag==1) break;
            }
            // 5개가 되면 빙고 한 줄 완성
            if(c==5) cnt++;
            if(r==5) cnt++;
            if(crs1==5){
                cnt++;
                crs1 = 0;
            }
            if(crs2==5){
                cnt++;
                crs2 = 0;
            }

            if(cnt>=3){
                System.out.println(i+1);
                return;
            }
        }
    }
}