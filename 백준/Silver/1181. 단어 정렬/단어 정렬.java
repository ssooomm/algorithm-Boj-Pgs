import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(br.readLine());
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list,(e1,e2)->{
            if(e1.length() == e2.length()) return e1.compareTo(e2);
            else return e1.length() - e2.length();
        });
        
        while(!list.isEmpty()){
            System.out.println(list.remove(0));
        }
    }
}