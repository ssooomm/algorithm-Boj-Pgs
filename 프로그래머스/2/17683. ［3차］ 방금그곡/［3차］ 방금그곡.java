import java.util.*;

class Solution {
    class Music implements Comparable<Music>{
        int time;
        String title;
        List<String> info;
        public Music(int time,String title,List<String> info){
            this.time = time;
            this.title = title;
            this.info = info;
        }
        @Override
        public int compareTo(Music o){
            return o.time-this.time;
        }
    }
    
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        
        List<Music> res = new ArrayList<>();
        for(String mi:musicinfos){
            String[] arr = mi.split(",");
            
            String[] tmp = arr[0].split(":");
            int sttime = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
            tmp = arr[1].split(":");
            int endtime = Integer.parseInt(tmp[0])*60 + Integer.parseInt(tmp[1]);
            int time = endtime - sttime;
            
            List<String> list = new ArrayList<>();
            for(int i=0;i<arr[3].length();i++){
                char ch = arr[3].charAt(i);
                if(ch=='#'){
                    list.set(list.size()-1, list.get(list.size()-1)+"#");
                }else list.add(String.valueOf(ch));
            }
            
            List<String> info = new ArrayList<>();
            for(int i=0;i<time;i++){
                info.add(list.get(i%list.size()));
            }
            
            res.add(new Music(time,arr[2],info));
        }
        Collections.sort(res);
        
        List<String> mm = new ArrayList<>();
        for(int i=0;i<m.length();i++){
            char ch = m.charAt(i);
            if(ch=='#'){
                mm.set(mm.size()-1,mm.get(mm.size()-1)+"#");
            }else mm.add(String.valueOf(ch));
        }
        
        for(Music cur:res){
            // System.out.println(cur.info);
            if(cur.time<mm.size()) continue;
            
            List<Integer> idx = new ArrayList<>();
            for(int i=0;i<cur.time;i++){
                if(cur.info.get(i).equals(mm.get(0))){
                    idx.add(i);
                }
            }
            if(idx.size()==0) continue;
            
            for(int i:idx){
                boolean flag =false;
                if(cur.time-i<mm.size()) continue;
                for(int x=0;x<mm.size();x++){
                    if(!cur.info.get((i+x)).equals(mm.get(x))){
                        flag = true;
                        break;
                    }
                }
                if(!flag) return cur.title;
            }
        }
        return "(None)";
    }
}