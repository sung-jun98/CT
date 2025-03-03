

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char[][] board;
	static int[] orders;

	static int[] dx = { 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	static ArrayList<int[]> crazy;
	static int meX, meY;

	static int turn;
	static int[][] tmpBoard;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		crazy = new ArrayList<>();
		tmpBoard = new int[N][M];

		turn = 0;

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < M; j++) {
				board[i][j] = input.charAt(j);
				if (input.charAt(j) == 'I') {
					meX = i;
					meY = j;
				} else if (input.charAt(j) == 'R') {
					crazy.add(new int[] { i, j });
				}
			}
		}

		String inputOrder = br.readLine();
		int orderNum = inputOrder.length();
		orders = new int[orderNum];

		for (int i = 0; i < orderNum; i++) {
			orders[i] = inputOrder.charAt(i) - '1';
		}

		for (int i = 0; i < orderNum; i++) {
			// 자기자신 움직임
			int nx = meX + dx[orders[i]];
			int ny = meY + dy[orders[i]];

			if (isIn(nx, ny)) {
				board[meX][meY] = '.';
				// 미친 아두이노와 만날 경우
				if (board[nx][ny] == 'R') {
					System.out.println("kraj " + (i + 1));
					return;
				}

				board[nx][ny] = 'I';
				meX = nx;
				meY = ny;
			}

			// 미친 아두이노들이 가야 할 다음 좌표 계산
			for (int[] current : crazy) {
				int sub = Integer.MAX_VALUE;
				int nxCurr = -1;
				int nyCurr = -1;

				for (int j = 0; j < 9; j++) {
					int nxTmp = current[0] + dx[j];
					int nyTmp = current[1] + dy[j];
					
					if (isIn(nxTmp, nyTmp)) {
						int dist = Math.abs(nxTmp - meX) + Math.abs(nyTmp - meY);
						if (dist < sub) {
							sub = dist;
							nxCurr = nxTmp;
							nyCurr = nyTmp;
						}
					}
				}

				// 2개 이상의 미친아두이노가 있을 경우를 대비해 tmpBoard에 적재
				tmpBoard[nxCurr][nyCurr] += 1;
				board[current[0]][current[1]] = '.';
				
				if (board[nxCurr][nyCurr] == 'I') {
					System.out.println("kraj " + (i + 1));
					return ;
				}
				
			}
			
			crazy.clear(); // 새로 추가
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if(tmpBoard[j][k] == 1) {
						board[j][k] = 'R';
						crazy.add(new int[] { j, k }); // 새로 추가
					}
					
					else if(tmpBoard[j][k] >= 2) {
						board[j][k] = '.';
					}
				}
			}
			
			tmpBoard = new int[N][M];
		}

		// 최종 상태의 board 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

	private static boolean isIn(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}

}
