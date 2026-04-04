class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = new int[rows+1][columns+1];
        int cnt=1;
        for(int i=1;i<=rows;i++){
            for(int j=1;j<=columns;j++){
                arr[i][j] = cnt++;
            }
        }
        
        int idx=0;
        for(int[] q:queries){
            int x1 = q[0];
            int y1 = q[1];
            int x2 = q[2];
            int y2 = q[3];
            int org=0,copy=arr[x1][y1];
            int min = copy;
            for(int i=y1+1;i<=y2;i++){
                org = arr[x1][i];
                arr[x1][i] = copy;
                copy =org;
                min = Math.min(min,copy);
            }
            for(int i=x1+1;i<=x2;i++){
                org = arr[i][y2];
                arr[i][y2] = copy;
                copy = org;
                min = Math.min(min,copy);
            }
            for(int i=y2-1;i>=y1;i--){
                org = arr[x2][i];
                arr[x2][i] = copy;
                copy=org;
                min = Math.min(min,copy);
            }
            for(int i=x2-1;i>=x1;i--){
                org = arr[i][y1];
                arr[i][y1] = copy;
                copy=org;
                min = Math.min(min,copy);
            }
            answer[idx++] = min;
        }
        return answer;
    }
}