
import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> subjects;
    static int[] chasu;
    static Deque<Integer> deque;
    static int[] semester;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        subjects = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        chasu = new int[N + 1];
        deque = new ArrayDeque<Integer>();
        semester = new int[N + 1];
        
        for (int i = 0; i <= N; i++) {
            subjects.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            subjects.get(A).add(B);
            chasu[B] += 1;
        }

        for (int i = 1; i < N + 1; i++) {
            if (chasu[i] == 0) {
                deque.offerLast(i);
                semester[i] = 1;
            }
        }

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();

            for (int next : subjects.get(current)) {
                chasu[next] -= 1;

                if (chasu[next] == 0) {
                    deque.offerLast(next);
                }

                if (semester[next] < semester[current] + 1) {
                    semester[next] = semester[current] + 1;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(semester[i] + " ");
        }
    }
}
