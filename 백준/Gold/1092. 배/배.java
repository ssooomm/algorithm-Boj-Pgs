import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> cr = new ArrayList<>();
        for(int i=0;i<n;i++){
            cr.add(Integer.parseInt(st.nextToken()));
        }
        cr.sort(Collections.reverseOrder());
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> box = new ArrayList<>();
        for(int i=0;i<m;i++){
            box.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(box);
        
        if(cr.get(0)<box.get(m-1)){
            System.out.println("-1");
            return;
        }
        
        int res=0;
        int cr_idx=0,b_idx=m-1;
        while(!box.isEmpty()){
            if(cr.get(cr_idx)>=box.get(b_idx)){
                box.remove(b_idx);
                cr_idx++;
            }
            b_idx--;
            if(cr_idx==n||b_idx==-1){
                cr_idx=0;
                b_idx=box.size()-1;
                res++;
            }
        }
        System.out.println(res);
    }
}