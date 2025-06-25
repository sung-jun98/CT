import java.io.*;
import java.util.*;

public class Main {
    static int n, m;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        UnionAndFind uf = new UnionAndFind(n);

        for (int i = 0; i < m; i++) {
            String[] inputLine = br.readLine().split(" ");
            int command = Integer.parseInt(inputLine[0]);
            int a = Integer.parseInt(inputLine[1]);
            int b = Integer.parseInt(inputLine[2]);

            if (command == 0) {
                uf.union(a, b);
            } else if (command == 1) {
                int findA = uf.find(a);
                int findB = uf.find(b);

                if (findA == findB) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static class UnionAndFind {
        private int[] parents;

        UnionAndFind(int n) {
            this.parents = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parents[i] = i;
            }
        }

        private int find(int n) {
            if (parents[n] != n) {
                parents[n] = find(parents[n]);
            }

            return parents[n];
        }

        private boolean union(int a, int b) {

            int parentA = find(a);
            int parentB = find(b);

            if (parentA == parentB) {
                return false;
            }

            parents[parentB] = parentA;
            return true;
        }
    }
}
