import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] arr = new int[n][n];
        int total = n*(n+1)/2;
        int x=0,y=0,cnt=n;
        int num=1;
        while(num<=total){
            for(int i=x;i<x+cnt;i++){
                arr[i][y] = num++;
                if(num>total) break;
            }
            cnt--;
            x+=cnt;
            y++;
            for(int i=y;i<y+cnt;i++){
                arr[x][i] = num++;
                if(num>total) break;
            }
            cnt--;
            y+=cnt-1;
            x--;
            for(int i=0;i<cnt;i++){
                arr[x--][y--] = num++;
                if(num>total) break;
            }
            cnt--;
            x+=2;
            y+=1;
        }

        
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                list.add(arr[i][j]);
            }
        }
        
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
    }

}