import java.util.*;
import java.io.*;

public class Main {
    static int N, r, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int size = (int) Math.pow(2, N);

        divide(size, 0, 0, 0);

    }

    private static void divide(int size, int startX, int startY, int value) {
        if (size == 1) {
            if (startX == r && startY == c) {
                System.out.println(value);
                System.exit(0);
            }

            return;
        }

        int half = size / 2;
        int quantSize = half * half;

        if (r < startX + half && c < startY + half) {
            divide(half, startX, startY, value);

        } else if (r < startX + half && c >= startY + half) {
            divide(half, startX, startY + half, value + quantSize);

        } else if (r >= startX + half && c < startY + half) {
            divide(half, startX + half, startY, value + quantSize * 2);

        } else {
            divide(half, startX + half, startY + half, value + quantSize * 3);

        }
    }
}
