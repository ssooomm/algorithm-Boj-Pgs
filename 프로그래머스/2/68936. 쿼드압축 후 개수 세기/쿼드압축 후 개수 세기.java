class Solution {
    static int[][] array;
    static int len=0;
    static int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        array = arr;
        
        divide(arr.length,0,0);
        
        return answer;
    }
    
    void divide(int n,int x,int y){
        if(check(n,x,y)){
            answer[array[x][y]]++;
            return;
        }
        
        int sh = n/2;
        divide(sh,x,y);
        divide(sh,x+sh,y);
        divide(sh,x,y+sh);
        divide(sh,x+sh,y+sh);
        
    }
    
    boolean check(int n,int x,int y){
        int num = array[x][y];
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(num!=array[i][j]) return false;
            }
        }
        return true;
    }
}