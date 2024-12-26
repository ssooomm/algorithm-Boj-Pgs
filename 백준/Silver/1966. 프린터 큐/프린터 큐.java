import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        LinkedList<int[]> q; //큐로 활용할 연결리스트

        while(tc-- >0){
            st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            q = new LinkedList<>();

            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<n;i++){
                // { 초기위치, 중요도 }
                q.add(new int[] {i,Integer.parseInt(st.nextToken())});
            }

            // 출력 횟수
            int cnt = 0;

            while(!q.isEmpty()){
                int[] front = q.remove();
                boolean isMax = true; // front가 가장 큰 원소인지 판단

                // 큐에 남아있는 원소들과 중요도 비교
                for(int i=0; i<q.size(); i++) {
                    // 처음 뽑은 원소보다 큐에 있는 i번째 원소가 중요도가 클 경우
                    if(front[1] < q.get(i)[1]){
                        // 뽑은 원소 및 i 이전의 원소들을 뒤로 보냄
                        q.add(front);
                        for(int j=0;j<i;j++){
                            q.add(q.remove());
                        }
                        // front가 가장 큰 원소가 아님
                        isMax = false;
                        break;
                    }
                }

                // front 원소가 가장 큰 원소가 아니니까 다음으로 넘어감
                if(isMax==false){
                    continue;
                }

                // front가 가장 큰 원소임
                cnt++;
                // 찾고자 하는 원소가 맞음
                if(front[0]==m){
                    break;
                }
            }
            System.out.println(cnt);

        }
    }
}