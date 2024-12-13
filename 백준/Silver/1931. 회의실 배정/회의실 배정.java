
import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<int[]> room;
	static int flag;
	static int answer;
	static Comparator<int []> comparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[1] != o2[1]) {
				return Integer.compare(o1[1], o2[1]);
			}
			return Integer.compare(o1[0], o2[0]);
		}
	};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		room = new ArrayList<>(N);
		flag = 0;

		answer = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			room.add(new int[] {a, b});
		}
		
		Collections.sort(room, comparator);
		flag = room.get(0)[1];
		answer += 1;
		
		for (int i = 1; i < N; i++) {
			if(room.get(i)[0] >= flag) {
				flag = room.get(i)[1];
				answer += 1;
				//System.out.println(Arrays.toString(room.get(i)));
			}
		}
		
		System.out.println(answer);
	}
}
