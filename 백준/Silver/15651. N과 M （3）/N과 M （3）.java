
import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        makePermutation(0, new int[M]);

        System.out.println(sb.toString());
    }

    private static void makePermutation(int cnt, int[] selected){
        // 종료조건
        if(cnt == M){
            for(int tmp : selected){
                sb.append(tmp).append(" ");
                //System.out.print(tmp + " ");
            }
            sb.append("\n");
//            System.out.println();
            return ;
        }

        for(int i=1; i<=N; i++) {
            selected[cnt] = i;
            makePermutation(cnt + 1, selected);
        }
    }
}
