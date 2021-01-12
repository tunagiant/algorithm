package other;

//코사라주		2150번
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
/* case
7 9
1 4
4 5
5 1
1 6
6 7
2 7
7 3
3 7
7 2
 */
import java.util.TreeMap;

public class scc01 {
	private static boolean[] visited;
	private static ArrayList<ArrayList<Integer>> digraph;	// 방향그래프
	private static ArrayList<ArrayList<Integer>> rdigraph;	// 역방향그래프
	private static ArrayList<ArrayList<Integer>> res;		// 결과저장
	private static Stack<Integer> stack;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		digraph = new ArrayList<ArrayList<Integer>>();
		rdigraph = new ArrayList<ArrayList<Integer>>();
		res = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i <= V; i++) {
			digraph.add(new ArrayList<Integer>());
			rdigraph.add(new ArrayList<Integer>());
			res.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			digraph.get(A).add(B);
			rdigraph.get(B).add(A);
		}

		visited = new boolean[V + 1];
		stack = new Stack<Integer>();

		// 방향 그래프에 대하여 dfs를 수행하고 탐색이 종료되는 점부터 스택에 push함
		for (int i = 1; i <= V; i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}

		Arrays.fill(visited, false);
		int groupNum = 0;

		// 역방향 그래프에 대하여 dfs를 수행
		while (!stack.isEmpty()) {
			int start = stack.pop();
			// 이때 방문 체크된 것은 이미 start가 하나의 SCC 그룹에 속해 있다는뜻
			if (visited[start]) {
				continue;
			}

			redfs(start, groupNum);
			groupNum++;
		}

		StringBuilder sb = new StringBuilder();
		sb.append(groupNum + "\n"); // SCC 그룹 개수 출력

		// TreeMap : Key순으로 정렬
		TreeMap<Integer, Integer> map = new TreeMap<>(); // key를 기준으로 오름차순정렬
		for (int i = 0; i < groupNum; i++) {
			Collections.sort(res.get(i)); // 각각 SCC 그룹 오름차순 정렬
			map.put(res.get(i).get(0), i);
			// key : SCC 그룹의 첫번째 항, value : 인덱스(맵은 순서 저장안되지만, 임의로 정함)

		}

		// map 의 value를 이용하여 첫번째 항이 작은 순서대로 출력
		// forEach : 함수형 인터페이스	이경우는 consumer 인터페이스
		map.keySet().forEach(key -> {
			int value = map.get(key);		// value : 인덱스

			for (int now : res.get(value)) {
				sb.append(now + " ");
			}
			sb.append("-1\n");
		});

		System.out.println(sb.toString());

	}

	// 전형적인 dfs + 끝 부분에 stack 에 push
	private static void dfs(int start) {
		visited[start] = true;

		for (int now : digraph.get(start)) {
			if (!visited[now]) {
				dfs(now);
			}
		}
		stack.push(start);
	}

	// 전형적인 dfs + 끝 부분에서 결과값 담는 res코드 추가됨
	private static void redfs(int start, int groupNum) {
		visited[start] = true;
		res.get(groupNum).add(start);

		for (int now : rdigraph.get(start)) {
			if (!visited[now]) {
				redfs(now, groupNum);
			}
		}
	}

}
