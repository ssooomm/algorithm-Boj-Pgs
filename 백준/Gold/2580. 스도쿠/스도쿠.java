import java.util.*;

public class Main{
    static int[][] arr = new int[9][9];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        sudoku(0,0);
    }
    
    public static void sudoku(int row, int col){
        //행 다 채워지면 다음 행의 첫 열부터
        if(col==9){
            sudoku(row+1,0);
            return;
        }
        //행,열 모두 채워지면 종료
        if(row==9){
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(arr[i][j]+" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        
        if(arr[row][col]==0){
            for(int i=1;i<=9;i++){
                if(psb(row,col,i)){
                    arr[row][col] = i;
                    sudoku(row,col+1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        sudoku(row,col+1);
    }
    
    public static boolean psb(int row, int col, int v){
        for(int i=0;i<9;i++){
            if(arr[row][i] == v){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(arr[i][col] == v){
                return false;
            }
        }
        
        //중복있는지
        int ridx = (row/3)*3;
        int cidx = (col/3)*3;
        
        for(int i=ridx;i<ridx+3;i++){
            for(int j=cidx;j<cidx+3;j++){
                if(arr[i][j]==v){
                    return false;
                }
            }
        }
        return true;
    }
}