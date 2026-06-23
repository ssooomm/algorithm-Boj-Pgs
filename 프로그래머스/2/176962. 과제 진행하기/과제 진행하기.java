import java.util.*;

class Solution {
    class Node implements Comparable<Node>{
        String title;
        int time;
        int rest;
        Node(String title,int time,int rest){
            this.title = title;
            this.time = time;
            this.rest = rest;
        }
        
        @Override
        public int compareTo(Node o){
            return Integer.compare(this.time,o.time);
        }
    }
    public String[] solution(String[][] plans) {
        int len = plans.length;
        String[] answer = new String[len];
        
        Queue<Node> pq = new PriorityQueue<>();
        
        for(int i=0;i<len;i++){
            String[] arr = plans[i][1].split(":");
            int t = Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
            pq.add(new Node(plans[i][0],t,Integer.parseInt(plans[i][2])));
        }
        
        
        Deque<Node> stack = new ArrayDeque<>();
        List<String> ans = new ArrayList<>();
        Node f = pq.remove();
        while(!pq.isEmpty()){
            Node s = pq.remove();
            if(f.time+f.rest<=s.time){
                ans.add(f.title);
                int tmp = s.time - (f.time+f.rest);
                while(!stack.isEmpty()){
                    Node ss = stack.pop();
                    if(tmp<ss.rest){
                        ss.rest-=tmp;
                        stack.push(ss);
                        break;
                    }else{
                        tmp-=ss.rest;
                        ans.add(ss.title);
                        continue;
                    }
                }
            }
            else{
                int tmp = f.rest-(s.time-f.time);
                f.rest = tmp;
                stack.push(f);
            }
            f = s;
        }
        ans.add(f.title);
        while(!stack.isEmpty()){
            ans.add(stack.pop().title);
        }
        
        for(int i=0;i<len;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}