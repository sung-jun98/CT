import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] inputs;
    static int white, blue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        inputs = new int[N][N];
        white = 0;
        blue = 0;

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                inputs[i][j] = Integer.parseInt(line[j]);
            }
        }

        split(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void split(int len, int x, int y) {
        int count = 0;

        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (inputs[i][j] == 0) {
                    count += 1;
                }
            }
        }

        if (count == len * len) {
            white += 1;
        } else if (count == 0) {
            blue += 1;
        } else {
            int nextLen = len / 2;
            if (nextLen != 0) {
                split(nextLen, x, y);
                split(nextLen, x + nextLen, y);
                split(nextLen, x, y + nextLen);
                split(nextLen, x + nextLen, y + nextLen);
            }

        }
    }
}
