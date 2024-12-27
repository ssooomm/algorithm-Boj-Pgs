import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        LinkedList<Integer> dq = new LinkedList<>();
        int[] ex = new int[M];
        for(int i=0;i<M;i++){
            ex[i] = sc.nextInt();
        }
        for(int j=1;j<=N;j++){
            dq.add(j);
        }
        int cnt=0;
        for(int i=0;i<M;i++){
            int x = dq.indexOf(ex[i]);
            // 변화는 dq의 크기에 따라 앞에서 뽑을지, 뒤에서 뽑을지 달라짐
            // 앞단의 원소만 제거 가능하기 때문에 연산 횟수 줄이려면 2번 연산 위주로 해야함 
            if(x<=dq.size()/2){
                while(ex[i]!=dq.getFirst()){
                    dq.addLast(dq.removeFirst());
                    cnt++;
                }
                dq.removeFirst();
            }
            else{
                while(ex[i]!=dq.getLast()){
                    dq.addFirst(dq.removeLast());
                    cnt++;
                }
                // 뽑아내기는 제일 앞단에 왔을 때만 가능
                dq.removeLast();
                // 3번 연산을 한거랑 마찬가지라 횟수 증가
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}