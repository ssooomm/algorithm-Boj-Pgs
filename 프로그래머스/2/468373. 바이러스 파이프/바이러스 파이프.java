import java.util.*;

class Solution {
    static List<int[]>[] list;
    static int max;
    public int solution(int n, int infection, int[][] edges, int k) {
        list = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            list[i] = new ArrayList<>();
        }
        
        Set<Integer> set = new HashSet<>();
        for(int[] e:edges){
            list[e[0]].add(new int[]{e[1],e[2]});
            list[e[1]].add(new int[]{e[0],e[2]});
            set.add(e[2]);
        }
        int[] type = new int[set.size()];
        int i=0;
        for(int s:set){
            type[i++] = s;
        }
        
        List<Integer> virus = new ArrayList<>();
        virus.add(infection);
        boolean[] visited = new boolean[n+1];
        visited[infection] = true;
        
        make(virus,visited,0,type,k);

        return max;
    }
    
    void make(List<Integer> virus, boolean[] visited, int depth, int[] type, int k){
        if(depth==k){
            max = Math.max(max, virus.size());
            return;
        }
        for(int i=0;i<type.length;i++){
            int nextt = type[i]; //파이프 열고
            
            boolean[] nextv = visited.clone();
            List<Integer> nextvirus = new ArrayList<>(virus);
            
            bfs(nextt,nextvirus,nextv);
            
            make(nextvirus,nextv,depth+1, type, k); //다음 파이프
            
        }
    }
    
    void bfs(int type, List<Integer> virus,boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        for(int v:virus){
            q.add(v);
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int[] l:list[cur]){
                if(!visited[l[0]]&&l[1]==type){
                    visited[l[0]] = true;
                    q.add(l[0]);
                    virus.add(l[0]);
                }
            }
        }
    }
}