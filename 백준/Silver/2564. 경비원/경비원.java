import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int num;
    static List<int[]> people;
    static int[] start;
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(br.readLine());

        people = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());

            int[] input = new int[]{dir, pos};
            people.add(input);
        }

        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int pos = Integer.parseInt(st.nextToken());

        start = new int[]{dir, pos};

        for (int[] curr : people) {
            int currDir = curr[0];
            int currPos = curr[1];

            switch (currDir) {
                case 1: 
                    if (start[0] == 1) { 
                        answer += Math.abs(start[1] - currPos);
                    } else if (start[0] == 2) {
                        int dist1 = start[1] + M + currPos; 
                        int dist2 = (N - start[1]) + M + (N - currPos); 
                        answer += Math.min(dist1, dist2);
                    } else if (start[0] == 3) { 
                        answer += start[1] + currPos;
                    } else if (start[0] == 4) { 
                        answer += start[1] + (N - currPos);
                    }
                    break;

                case 2: 
                    if (start[0] == 1) { 
                        int dist1 = start[1] + M + currPos; 
                        int dist2 = (N - start[1]) + M + (N - currPos);
                        answer += Math.min(dist1, dist2);
                    } else if (start[0] == 2) { 
                        answer += Math.abs(start[1] - currPos);
                    } else if (start[0] == 3) { 
                        answer += (M - start[1]) + currPos;
                    } else if (start[0] == 4) { 
                        answer += (M - start[1]) + (N - currPos);
                    }
                    break;

                case 3: 
                    if (start[0] == 1) {
                        answer += start[1] + currPos;
                    } else if (start[0] == 2) { 
                        answer += start[1] + (M - currPos);
                    } else if (start[0] == 3) {
                        answer += Math.abs(currPos - start[1]);
                    } else if (start[0] == 4) { 
                        int dist1 = currPos + N + start[1];
                        int dist2 = (M - currPos) + N + (M - start[1]); 
                        answer += Math.min(dist1, dist2);
                    }
                    break;

                case 4: 
                    if (start[0] == 1) {
                        answer += (N - start[1]) + currPos;
                    } else if (start[0] == 2) {
                        answer += (N - start[1]) + (M - currPos);
                    } else if (start[0] == 3) { 
                        int dist1 = currPos + N + start[1]; 
                        int dist2 = (M - currPos) + N + (M - start[1]); 
                        answer += Math.min(dist1, dist2);
                    } else if (start[0] == 4) { 
                        answer += Math.abs(start[1] - currPos);
                    }
                    break;
            }
        }

        System.out.println(answer);
    }
}