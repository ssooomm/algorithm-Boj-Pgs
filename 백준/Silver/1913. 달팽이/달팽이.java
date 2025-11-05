import java.util.*;

public class Main{
    static int[][] arr;
    static int n, search;
    static int num=1;
    static int[] cor = new int[2];
    static int[] dx = {0,1,0,-1};
    static int[] dy = {-1,0,1,0};
    static int x,y;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        search = sc.nextInt();
        arr = new int[n+1][n+1];
        int st = n/2+1;
        //arr[st][st] = num;
        x=st;
        y=st;
        int d=0,cnt=1;
        while(num<=n*n){
            print(d,cnt);
            d++;
            d%=4;
            print(d,cnt);
            cnt++;
            d++;
            d%=4;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        sb.append(cor[0]+" "+cor[1]);
        System.out.println(sb);
        
    }
    
    static void print(int d, int cnt){
        while(cnt-->0){
            if(num==search){
                cor[0] = y;
                cor[1] = x;
            }
            arr[y][x] = num++;
            
            x+=dx[d];
            y+=dy[d];
            if(num+1>n*n) return;
        }
    }
}