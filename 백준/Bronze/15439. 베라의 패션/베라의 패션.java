import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;

        permute15439(0, 1, 1);
        System.out.println(answer);
    }

    private static void permute15439(int dept, int topSelected, int bottomSelected) {
        if (dept == 2) {
            if (topSelected != bottomSelected) {
                answer += 1;
            }

            return;
        }

        if (dept == 0) {
            for (int i = topSelected; i <= N; i++) {
                permute15439(1, i, bottomSelected);
            }

        } else if (dept == 1) {
            for (int i = bottomSelected; i <= N; i++) {
                permute15439(2, topSelected, i);
            }
        }
    }
}
