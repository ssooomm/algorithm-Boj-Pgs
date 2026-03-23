import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Queue<int[]> q = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        
        for(String[] book:book_time){
            int[] tmp = new int[2];
            
            String[] time = book[0].split(":");
            int h = Integer.parseInt(time[0]);
            tmp[0] = h*60+Integer.parseInt(time[1]);

            time = book[1].split(":");
            h = Integer.parseInt(time[0]);
            tmp[1] = h*60+Integer.parseInt(time[1])+10; 
            
            q.add(tmp);
        }
        
        int[] arr = new int[1000];
        Arrays.fill(arr,-1);
        arr[0] = q.poll()[1];
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            for(int i=0;i<1000;i++){
                if(arr[i]==-1||arr[i]<=tmp[0]){
                    arr[i] = tmp[1];
                    break;
                }
                
            }
        }
        
        for(int i=0;i<1000;i++){
            if(arr[i]!=-1) answer++;
            else if(arr[i]==-1) break;
        }
        return answer;
    }
}