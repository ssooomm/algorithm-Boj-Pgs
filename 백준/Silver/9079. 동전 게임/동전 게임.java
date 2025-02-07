import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int i=0;i<t;i++){
            String coins = "";
            for(int x=0;x<3;x++){
                for(int y=0;y<3;y++){
                    coins += sc.next();
                }
            }
            System.out.println(bfs(coins));
        }
    }

    static int bfs(String coins){
        Map<String,Integer> map = new HashMap<>();
        Queue<String> q = new ArrayDeque<>();
        q.add(coins);
        map.put(coins,0);

        while(!q.isEmpty()){
            String tmp = q.poll();
            int cnt = map.get(tmp);

            if(check(tmp)) return cnt;

            String nexts;

            // 행 뒤집기
            for(int i=0;i<9;i+=3){
                nexts = flip_row(tmp,i);
                if(!map.containsKey(nexts)||map.get(nexts)>cnt+1){
                    map.put(nexts,cnt+1);
                    q.add(nexts);
                }
            }

            // 열 뒤집기
            for(int i=0;i<3;i++){
                nexts = flip_col(tmp,i);
                if(!map.containsKey(nexts)||map.get(nexts)>cnt+1){
                    map.put(nexts,cnt+1);
                    q.add(nexts);
                }
            }

            // 대각선1
            nexts = flip_cross1(tmp);
            if(!map.containsKey(nexts)||map.get(nexts)>cnt+1){
                map.put(nexts,cnt+1);
                q.add(nexts);
            }

            // 대각선2
            nexts = flip_cross2(tmp);
            if(!map.containsKey(nexts)||map.get(nexts)>cnt+1){
                map.put(nexts,cnt+1);
                q.add(nexts);
            }
        }
        return -1;
    }

    static String flip_row(String str, int st){
        StringBuilder coins = new StringBuilder(str);
        for(int i=st;i<st+3;i++){
            char coin = coins.charAt(i);
            coins.deleteCharAt(i);
            if(coin=='H') coins.insert(i,'T');
            else coins.insert(i,'H');
        }
        return coins.toString();
    }

    static String flip_col(String str, int st){
        StringBuilder coins = new StringBuilder(str);
        for(int i=st;i<9;i+=3){
            char coin = coins.charAt(i);
            coins.deleteCharAt(i);
            if(coin=='H') coins.insert(i,'T');
            else coins.insert(i,'H');
        }
        return coins.toString();
    }

    static String flip_cross1(String str){
        StringBuilder coins = new StringBuilder(str);
        for(int i=0;i<9;i+=4){
            char coin = coins.charAt(i);
            coins.deleteCharAt(i);
            if(coin=='H') coins.insert(i,'T');
            else coins.insert(i,'H');
        }
        return coins.toString();
    }

    static String flip_cross2(String str){
        StringBuilder coins = new StringBuilder(str);
        for(int i=2;i<=6;i+=2){
            char coin = coins.charAt(i);
            coins.deleteCharAt(i);
            if(coin=='H') coins.insert(i,'T');
            else coins.insert(i,'H');
        }
        return coins.toString();
    }

    static boolean check(String str){
        char coin = str.charAt(0);
        for(int i=1;i<9;i++){
            if(coin != str.charAt(i)) return false;
        }
        return true;
    }
}