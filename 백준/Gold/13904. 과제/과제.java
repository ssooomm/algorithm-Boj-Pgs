import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();
        int maxDay = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new int[]{d,w});
            maxDay = Math.max(maxDay, d);
        }

        int sum = 0;
        for(int i=maxDay;i>0;i--){
            sum+=getMaxScore(list, i);
        }
        System.out.println(sum);
    }

    static int getMaxScore(List<int[]> list, int now){
        int idx = -1;
        int res = 0;
        for(int i=0;i<list.size();i++){
            // list에 있는 day중에 현재 날짜보다 많이 남았고
            // 과제 점수가 남은 것 중에 제일 큼 
            if(list.get(i)[0] >= now && res < list.get(i)[1]){
                idx = i;
                res = list.get(i)[1];
            }
        }
        if(res==0) return 0;
        list.remove(idx);
        return res;
    }
}