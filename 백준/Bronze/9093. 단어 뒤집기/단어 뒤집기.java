import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- >0){
            String str = br.readLine();
            String[] arr = str.split(" ");
            for(int i=0;i<arr.length;i++){
                for(int j=arr[i].length()-1;j>=0;j--){
                    sb.append(arr[i].charAt(j));
                }
                sb.append(" ");
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
}
