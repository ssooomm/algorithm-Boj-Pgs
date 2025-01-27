import java.util.*;

public class Main{
    static char[][] arr;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];
        draw(0,0,n,false);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
    
    static void draw(int x,int y, int n, boolean blank){
        //빈칸일 경우
        if(blank){
            for(int i=x;i<x+n;i++){
                for(int j=y;j<y+n;j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        
        //더 이상 쪼갤 수 없는 경우
        if(n==1){
            arr[x][y]='*';
            return;
        }
        
        int sh = n/3;
        int cnt = 0;
        for(int i=x;i<x+n;i+=sh){
            for(int j=y;j<y+n;j+=sh){
                cnt++;
                if(cnt==5){ //빈칸 나올 타임
                    draw(i,j,sh,true);
                }else{
                    draw(i,j,sh,false);
                }
            }
        }
    }
}