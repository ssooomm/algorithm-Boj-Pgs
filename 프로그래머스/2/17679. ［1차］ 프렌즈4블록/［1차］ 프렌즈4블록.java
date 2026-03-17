import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int ans=0;
        List<List<Character>> b = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            b.add(new ArrayList<>());
            for(int j=m-1;j>=0;j--){
                b.get(i).add(board[j].charAt(i));
            }
        }
        
        while(true){
            boolean[][] marked = new boolean[n][m];
            boolean flag = false;
            
            for(int i=0;i<n-1;i++){
                int min = Math.min(b.get(i).size(),b.get(i+1).size());
                for(int j=0;j<min-1;j++){
                    char ch = b.get(i).get(j);
                    
                    if(ch!=' '&&ch==b.get(i).get(j+1) &&ch==b.get(i+1).get(j)&&ch==b.get(i+1).get(j+1)){
                        marked[i][j] = marked[i][j+1] = marked[i + 1][j] = marked[i + 1][j + 1]= true;
                        flag = true;
                    }
                }
            }
            
            if(!flag) break;
            
            for(int i=0;i<n;i++){
                for(int j=b.get(i).size()-1;j>=0;j--){
                    if(marked[i][j]){
                        b.get(i).remove(j);
                        ans++;
                    }
                }
            }
        }
        
        return ans;
    }
    
    
}