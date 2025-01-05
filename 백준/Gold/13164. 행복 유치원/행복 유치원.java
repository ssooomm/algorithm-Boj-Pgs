import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int N = Integer.parseInt(s1[0]);
        int K = Integer.parseInt(s1[1]);
        
        int[] arr = new int[N];
        String[] s2 = br.readLine().split(" ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(s2[i]);
        }
        
        List<Integer> list = new ArrayList<>();
        // 인접한 2개의 차이 구하기
        for(int i=1;i<N;i++){
            list.add(arr[i]-arr[i-1]);
        }
        
        // 차이가 가장 적은 순서대로 정렬 
        Collections.sort(list);
        
        int sum = 0;
        // N-K : 합칠 횟수
        for(int i=0;i<N-K;i++){
            sum+=list.get(i);
        }
        System.out.println(sum);
        
    }
}