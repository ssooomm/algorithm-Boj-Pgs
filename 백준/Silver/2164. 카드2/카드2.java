import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            q.add(i+1);
        }

        while(q.size()>=2){
            q.poll();
            int tmp = q.poll();
            q.add(tmp);
        }

        System.out.println(q.poll());
    }
}
