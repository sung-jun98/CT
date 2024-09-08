
import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makeCombination(1, 0, new int[M]);

    }

    private static void makeCombination(int start, int cnt, int[] selected) { //시작 위치, 시도한 횟수
        // 종료조건
        if(cnt == M){
            for(int i=0; i<M; i++){
                System.out.print(selected[i] + " ");
            }
            System.out.println();
            return ;
        }

        for(int i=start; i<=N; i++){
            selected[cnt] = i;
            makeCombination(i+1, cnt+1, selected);
        }
    }
}
