import java.util.*;

public class Main{
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static Set<Integer> set = new HashSet<>();
    static int[][] arr = new int[5][5];
    public static class Node{
        int x;
        int y;
        String str;
        public Node(int x, int y, String str){
            this.x = x;
            this.y = y;
            this.str = str;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                bfs(i,j);
            }
        }
        
        System.out.println(set.size());
    }
    
    public static void bfs(int x, int y){
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x,y,""+arr[x][y]));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.str.length()==6){
                set.add(Integer.parseInt(cur.str));
            }else{
                for(int i=0;i<4;i++){
                    int nx = dx[i]+cur.x;
                    int ny = dy[i]+cur.y;
                    if(nx>=0&&nx<5&&ny>=0&&ny<5){
                        q.add(new Node(nx,ny,cur.str+arr[nx][ny]));
                    }
                }
            }
        }
    }
}