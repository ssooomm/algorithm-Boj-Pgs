import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time,(x,y)->x[0].compareTo(y[0]));
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]); //대실시간이 가장짧은 거 먼저

        int[][] time = new int[book_time.length][2];
        for(int i=0;i<book_time.length;i++){
            int start_time = Integer.parseInt(book_time[i][0].replace(":",""));
            int end_time = Integer.parseInt(book_time[i][1].replace(":",""));
            
            end_time+=10;
            if(end_time%100>=60){
                end_time+=40;
            }
            time[i][0]=start_time;
            time[i][1]=end_time;
        }

        ArrayList<Integer> rooms = new ArrayList<>();
        for(int i=0;i<time.length;i++){
            Collections.sort(rooms);
            
            boolean isAdd=false;
            
            for(int j=0;j<rooms.size();j++){
                if(time[i][0] >= rooms.get(j)){
                    rooms.set(j,time[i][1]);
                    isAdd=true;
                    break;
                }
            }
            
            if(!isAdd){
                rooms.add(time[i][1]);
            }
        }
        return rooms.size();
    }
}