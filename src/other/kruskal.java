package other;
// 간선 선택 기반, 그리디, MST

// 가중치 오름차순으로 정렬, 사이클X

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
/*case
 * 5 6
1 2 10
1 3 15
3 4 20
4 5 10
2 4 30
3 5 5
 *  */

public class kruskal {

	public static int parents[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1[] = br.readLine().split(" ");
		int V = Integer.parseInt(input1[0]);
		int E = Integer.parseInt(input1[1]);
		// 0 : start, 1 : end, 2 : cost
		int edges[][] = new int[E][3];

		// index 1번부터 시작
		parents = new int[V + 1];

		for (int i = 0; i < E; i++) {
			String input2[] = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(input2[0]);
			edges[i][1] = Integer.parseInt(input2[1]);
			edges[i][2] = Integer.parseInt(input2[2]);
		}

		// cost 오름차순으로(최소값)
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});

		Arrays.fill(parents, -1);

		int result = 0;
		int cnt = 0;

		for (int i = 0; i < edges.length; i++) {
			if (union(edges[i][0], edges[i][1]))
				;
			result += edges[i][2];
			cnt++;

			if (cnt == V - 1)
				break;
		}

		System.out.println(result);

	}

	public static int find(int x) {
		if (parents[x] < 0)
			return x;
		return parents[x] = find(parents[x]);
	}

	public static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);

		if (xRoot != yRoot) {
			parents[yRoot] = xRoot;
			return true;
		}
		// 연결을 하지 못한 경우
		return false;

	}
}
