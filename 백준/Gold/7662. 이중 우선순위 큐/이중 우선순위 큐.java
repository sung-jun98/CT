import java.util.*;
import java.io.*;

public class Main {
    static int T, k;
    static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            k = Integer.parseInt(br.readLine());
            StringTokenizer st;
            map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String comm = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(comm.equals("I")){
                    map.put(num, map.getOrDefault(num, 0) + 1);

                } else if(comm.equals("D") && !map.isEmpty()){
                    if(num == 1){
                        int maxKey = map.lastKey();
                        if(map.get(maxKey) == 1){
                            map.remove(maxKey);
                        } else{
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    } else if(num == -1){
                        int minKey = map.firstKey();
                        if(map.get(minKey) == 1){
                            map.remove(minKey);
                        } else{
                            map.put(minKey, map.get(minKey) - 1);
                        }

                    }
                }
            }

            if(map.isEmpty()){
                sb.append("EMPTY").append('\n');
            } else{

                int max = map.lastKey();
                int min = map.firstKey();

                sb.append(max).append(" ").append(min).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}
