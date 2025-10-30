import java.util.*;

public class Main{
    static int[][] map = new int[9][9];
    static boolean isP = true;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<9;i++){
            String str = sc.next();
            for(int j=0;j<9;j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        
        bt(0,0);
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
    static void bt(int r, int c){
        if(!isP) return;
        
        if(c==9){
            r++;
            c=0;
        }
        
        if(r==9){
            isP = false;
            return;
        }
        
        if(map[r][c]==0){
            for(int i=1;i<=9;i++){
                if(check(r,c,i)){
                    map[r][c] = i;
                    bt(r,c+1);

                    if(!isP) return;
                    map[r][c] = 0;
                }
            }
        }else{
            bt(r,c+1);
        }
    }
    
    static boolean check(int r,int c,int n){
        for(int i=0;i<9;i++){
            if(map[i][c]==n) return false;
        }
        for(int i=0;i<9;i++){
            if(map[r][i]==n) return false;
        }
        
        int nr = (r/3)*3;
        int nc = (c/3)*3;
        for(int i=nr;i<nr+3;i++){
            for(int j=nc;j<nc+3;j++){
                if(map[i][j]==n) return false;
            }
        }
        
        return true;
    }
}