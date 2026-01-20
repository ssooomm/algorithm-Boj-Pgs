import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] time = new int[100001];
        int[] cnt = new int[100001]; //방법의 수
        Arrays.fill(time,-1);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        time[n]=0;
        cnt[n] = 1; //처음 1가지 방법
        
        while(!q.isEmpty()){
            int x = q.poll();
            int[] next = {x-1,x+1,x*2};
            for(int ne:next){
                if(ne<0||ne>100000) continue;
                
                if(time[ne]==-1){ //최초
                    time[ne] = time[x]+1;
                    cnt[ne] = cnt[x]; //현재위치까지 온 방법의 수 그대로 전달
                    q.add(ne);
                }else if(time[ne]==time[x]+1){ //기존 최단 시간 방법과 같은 시간으로 도착하는 경로 추가 존재
                    cnt[ne]+=cnt[x];
                }
            }
            
        }
        System.out.println(time[k]);
        System.out.println(cnt[k]);
    }
}