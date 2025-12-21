import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    int num;
    int cnt;
    int time;
    
    public Node(int num,int cnt,int time){
        this.num = num;
        this.cnt = cnt;
        this.time = time;
    }
    
    @Override
    public int compareTo(Node o){ //추천순 -> 시간순 내림차순
        int res = o.cnt - cnt;
        if(res==0){
            return o.time - time;
        }
        return res;
    }
}
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int t = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        Node[] nodes = new Node[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<t;i++){
            int x = Integer.parseInt(st.nextToken());
            
            if(nodes[x] != null){ //이미 틀에 존재
                nodes[x].cnt++;
            }else{ //틀에 없음
                Collections.sort(list); //내림차순 정렬
                
                if(list.size()==n){ //틀 꽉참
                    Node tmp = list.remove(n-1); //맨 뒤가 우선순위 작음
                    nodes[tmp.num] = null; //틀 저장 정복 삭제
                }
                
                nodes[x] = new Node(x,1,i); //시간 정보 인덱스 순서로
                list.add(nodes[x]);
            }
            
        }
        Collections.sort(list,(o1,o2)->o1.num-o2.num); //정렬기준 새롭게
        StringBuilder sb = new StringBuilder();
        for(Node x:list){
            sb.append(x.num+" ");
        }
        System.out.println(sb);
    }
}