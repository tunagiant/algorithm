package other;

//에드몬드 카프 알고리즘
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/* case
7 9 1 7
1 2 2
1 3 7
2 4 3
3 4 5
3 5 5
4 6 4
5 6 1
5 7 2
6 7 6
 */

public class networkflow {
	static int N;
	static LinkedList<Node>[] arr;
	static int[] prev;
	static int MAX = 1005;
	static int[][] flow;
	static int[][] capacity;

	static int CtoI(char c) {
		if (c <= 'Z')
			return c - 'A';
		return c - 'a' + 26;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer token = new StringTokenizer(br.readLine());

		arr = new LinkedList[MAX];
		for (int i = 0; i < MAX; i++) {
			arr[i] = new LinkedList<>();
		}
		capacity = new int[MAX][MAX];
		flow = new int[MAX][MAX];
		N = Integer.parseInt(token.nextToken());
		for (int i = 1; i <= N; i++) {
			String[] temp = br.readLine().split(" ");
			int s = CtoI(temp[0].charAt(0));
			int e = CtoI(temp[1].charAt(0));
			int val = Integer.parseInt(temp[2]);
			capacity[s][e] += val;
			capacity[e][s] += val;
			arr[s].add(new Node(e, val));
			arr[e].add(new Node(s, val));
		}
		int S = CtoI('A');
		int E = CtoI('Z');
		int total = 0;
		// 증가 경로를 못찾을 때까지 돌린다.
		while (true) {
			int[] past = new int[MAX]; // 경로 기억
			Arrays.fill(past, -1);

			Queue<Node> que = new LinkedList<>();
			que.add(new Node(S, 0));// 처음 시작점에서 계속 돌려야됨
			while (!que.isEmpty() && past[E] == -1) {
				Node current = que.poll();
				for (Node node : arr[current.idx]) {
					if (capacity[current.idx][node.idx] - flow[current.idx][node.idx] > 0 && past[node.idx] == -1) {
						past[node.idx] = current.idx;
						que.add(new Node(node.idx, 0));
						if (node.idx == E) {
							break; // 목표점 도달시 나옴
						}
					}
				}
			}
			if (past[E] == -1)
				break; // 가는 곳이 더 없다면 루프 탈출

			int minValue = Integer.MAX_VALUE;
			for (int i = E; i != S; i = past[i]) {
				// 끝에서 시작점으로 움직임
				minValue = Math.min(minValue, capacity[past[i]][i] - flow[past[i]][i]);
			}
			for (int i = E; i != S; i = past[i]) {
				flow[past[i]][i] += minValue;
				flow[i][past[i]] -= minValue;
			}
			total += minValue;
		}
		System.out.println(total);
	}
}

class Node {
	public int idx;
	public long val;

	Node(int idx, long val) {
		this.idx = idx;
		this.val = val;
	}
}