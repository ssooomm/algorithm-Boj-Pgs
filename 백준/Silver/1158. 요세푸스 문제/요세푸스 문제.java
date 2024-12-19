import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        
        StringBuilder sb = new StringBuilder();
        
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        int idx = k-1, i=0;
        while(!list.isEmpty()){
            int size = list.size();
            if(size<=idx) idx%=size;
            arr[i++] = list.remove(idx);
            idx+=k-1;
        }
        sb.append("<");
        sb.append(arr[0]);
        for(int x=1;x<n;x++){
            sb.append(", "+arr[x]);
        }
        sb.append(">");
        System.out.println(sb);
    }
}