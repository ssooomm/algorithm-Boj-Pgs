import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //김밥 자르기
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x<=k) continue;
            else if(x<2*k) list.add(x - k);
            else list.add(x - (2 * k));
        }

        int res = -1;
        int start = 1;
        int end = 0;
        for (int x : list) {
            end = Math.max(x, end);
        }

        while (start <= end) {
            int mid = (end + start) / 2;
            int sum = 0;
            for (int x : list) {
                sum += x / mid;
            }

            //더 길게 자를 수 있는지 범위 조정
            if (sum >= m) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(res);
    }
}
