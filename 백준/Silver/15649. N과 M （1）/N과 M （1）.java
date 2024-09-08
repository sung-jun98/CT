
import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makePermutaion(0,new boolean[N+1], new int[M]);
    }

    private static void makePermutaion(int cnt, boolean[] visited,  int[] selected) {
        // 종료조건
        if(cnt == M){
            for(int result : selected){
                System.out.print(result + " ");
            }
            System.out.println();
            return ;
        }

        // 전체 조회
        for(int i=1; i<=N; i++){
            if(!visited[i]){
                selected[cnt] = i;
                visited[i] = true;
                makePermutaion(cnt+1, visited, selected);
                visited[i] = false;
            }
        }
    }
}

