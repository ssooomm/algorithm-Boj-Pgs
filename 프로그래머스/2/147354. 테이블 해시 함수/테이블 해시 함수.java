import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int r = data.length;
        int c = data[0].length;
        List<int[]> arr = new ArrayList<>();
        
        for(int i=0;i<r;i++){
            arr.add(data[i]);
        }

        int colidx = col-1;
        arr.sort((a,b)->{
            if(a[colidx]==b[colidx]) return b[0]-a[0];
            else return a[colidx]-b[colidx];
        });
        
        int xor=0;
        for(int i=row_begin-1;i<row_end;i++){
            int tmp=0;
            for(int j=0;j<c;j++){
                tmp+=arr.get(i)[j]%(i+1);
            }
            xor^=tmp;
        }
        
        return xor;
    }
}