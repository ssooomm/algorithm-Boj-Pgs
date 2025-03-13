import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int x = 0, y=0, cnt_x=0, cnt_y=0;
        while(x<w){
            cnt_x++;
            x+=m+1;
        }
        while(y<h){
            cnt_y++;
            y+=n+1;
        }
        System.out.println(cnt_x * cnt_y);
    }
}