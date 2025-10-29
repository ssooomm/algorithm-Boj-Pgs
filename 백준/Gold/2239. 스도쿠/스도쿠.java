import java.util.*;

public class Main{
    static int[][] map = new int[9][9];
    static boolean isSolved = false; //정답 찾은 후 재귀 그만 
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
        //이미 답 찾음 
        if(isSolved) return;
        
        //다음 행으로 
        if(c==9){
            r++;
            c=0;
        }
        
        // 행 끝까지 오면 스도쿠 완성 
        if(r==9){
            isSolved = true;
            return;
        }
        
        if(map[r][c]==0){ //채우기
            for(int n=1;n<=9;n++){ //사전순 1~9
                if(isP(r,c,n)){
                    map[r][c]=n; //대입
                    bt(r,c+1); //한 칸 옆으로
                    
                    //답 찾음
                    if(isSolved) return;
                    
                    //답 못 찾음 -> 채워준 칸 없애기
                    map[r][c] = 0;
                }
            }
        }
        else{
            //이미 채워진 칸
            bt(r,c+1);
        }
    }
    
    static boolean isP(int r,int c, int n){
        //가로 검사
        for(int i=0;i<9;i++){
            if(map[r][i]==n) return false;
        }
        
        //세로 검사
        for(int i=0;i<9;i++){
            if(map[i][c]==n) return false;
        }
        
        //3*3
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