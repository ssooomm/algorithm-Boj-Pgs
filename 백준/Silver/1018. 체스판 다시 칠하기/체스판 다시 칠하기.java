import java.util.*;

public class Main{
    static String[][] map;
    static int max_min = Integer.MAX_VALUE;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new String[n][m];
        for(int i=0;i<n;i++){
            String[] str = sc.next().split("");
            for(int j=0;j<m;j++){
                map[i][j] = str[j];
            }
        }

        for(int i=0;i<n-7;i++){
            for(int j=0;j<m-7;j++){
                paint(i,j,"W");
                paint(i,j,"B");
            }
        }
        System.out.println(max_min);
    }

    static void paint(int stX, int stY, String st){
        int cnt = 0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(i%2==0){
                    if(j%2==0){
                        if(!map[stX+i][stY+j].equals(st)){
                            cnt++;
                        }
                    }else{
                        if(map[stX+i][stY+j].equals(st)){
                            cnt++;
                        }
                    }
                }
                else{
                    if(j%2==0){
                        if(map[stX+i][stY+j].equals(st)){
                            cnt++;
                        }
                    }else{
                        if(!map[stX+i][stY+j].equals(st)){
                            cnt++;
                        }
                    }
                }

            }
        }
        max_min = Math.min(max_min,cnt);
    }
}