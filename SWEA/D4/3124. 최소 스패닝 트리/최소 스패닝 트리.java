
import java.lang.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int V, E; //정점의 개수, 간선의 개수
    static int[] parents;
    static void make() {
        parents = new int[V + 1];
        for (int i = 0; i < V; i++) {
            parents[i] = -1;
        } // Arrays.fill(parents, -1);
    }

    static int findSet(int a) {
        if (parents[a] < 0)
            return a;
        return parents[a] = findSet(parents[a]); // 집합의 대표자를 자신의 부모로 변경 : 패스 압축!
    }
    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) {
            return false;
        }

        // ===기존의 코드에 크루스칼을 위한 로직 추가
        // 집합의 크기에 따라 붙이도록 처리 가능
        // 편의상 a집합에 b집합을 붙임(집합의 크기에 따라 붙이도록 처리 가능)
        parents[aRoot] += parents[bRoot]; // 집합 크기관리 (절댓값을 사용하면 집합의 크기가 됨)
        parents[bRoot] = aRoot;
        // ====
        return true;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[E]; // 간선들

            for(int j=0; j<E; j++){
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken()); // 노드 a
                int node2 = Integer.parseInt(st.nextToken()); // 노드 b
                int weight = Integer.parseInt(st.nextToken()); // 가중치 c
                edges[j] = new Edge(node1, node2, weight); // a, b 사이의 가중치 c를 갖는 간선
            }

            Arrays.sort(edges); // 간선의 가중치 기준 오름차순 정렬
            make(); // 모든 정점을 분리집합으로 ... (단위 서로소 집합<트리> 생성)

            long cnt = 0, cost = 0;
            for (Edge edge : edges) {
                if (union(edge.start, edge.end)) {
                    cost += edge.weight;
                    if (++cnt == V - 1) { // 최소신장트리 생성완료
                        break;
                    }
                }
            }
            System.out.println("#" + i + " " + cost);
        }


    }

    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
