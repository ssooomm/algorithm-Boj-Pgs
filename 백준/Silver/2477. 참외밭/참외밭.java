import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int[] cnt = new int[5];
        Queue<int[]> q = new ArrayDeque<>();
        int g=0,s=0;
        for(int i=0;i<6;i++){
            int dir = sc.nextInt();
            int len = sc.nextInt();
            q.add(new int[]{dir,len});
            cnt[dir]++;
            if(dir==4||dir==3) s=Math.max(s,len);
            else if(dir==1||dir==2) g=Math.max(g,len);
        }
        int res = g*s;
        
        int x=0,y=0;
        if(cnt[1]==2&&cnt[3]==2){
            while(true){
                int[] a = q.poll();
                if(a[0]==1){
                    int[] b = q.poll();
                    if(b[0]==3){
                        x = a[1];
                        y = b[1];
                        break;
                    }else{
                        q.add(a);
                        q.add(b);
                    }
                }else q.add(a);
            }
            
        }else if(cnt[1]==2&&cnt[4]==2){
            while(true){
                int[] a = q.poll();
                if(a[0]==4){
                    int[] b = q.poll();
                    if(b[0]==1){
                        x = a[1];
                        y = b[1];
                        break;
                    }else{
                        q.add(a);
                        q.add(b);
                    }
                }else q.add(a);
            }
        }else if(cnt[2]==2&&cnt[4]==2){
            while(true){
                int[] a = q.poll();
                if(a[0]==2){
                    int[] b = q.poll();
                    if(b[0]==4){
                        x = a[1];
                        y = b[1];
                        break;
                    }else{
                        q.add(a);
                        q.add(b);
                    }
                }else q.add(a);
            }
        }else if(cnt[2]==2&&cnt[3]==2){
            while(true){
                int[] a = q.poll();
                if(a[0]==3){
                    int[] b = q.poll();
                    if(b[0]==2){
                        x = a[1];
                        y = b[1];
                        break;
                    }else{
                        q.add(a);
                        q.add(b);
                    }
                }else q.add(a);
            }
        }
        
        int tmp = x*y;
        System.out.println((res-tmp)*k);
    }
}