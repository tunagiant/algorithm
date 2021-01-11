package other;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*case

7 9
1 2
1 3
2 4
2 5
3 4
3 7
5 4
4 6
5 6
*/
import java.util.Queue;

public class topological_sort {
	
	static int N;
	static int E;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input1[] = br.readLine().split(" ");
		N = Integer.parseInt(input1[0]);
		E = Integer.parseInt(input1[1]);
		int[] indegree = new int[N];
		List<List<Integer>> array = new ArrayList<List<Integer>>();

		for (int i = 0; i < N; i++) {
			array.add(new ArrayList<Integer>());
		}

		// 입력받은 데이터로 인접행렬을 만드는 과정
		for (int i = 0; i < E; i++) {
			String input2[] = br.readLine().split(" ");
			int a = Integer.parseInt(input2[0]) - 1;
			int b = Integer.parseInt(input2[1]) - 1;
			
			array.get(a).add(b);
			indegree[b]++;
		}
		
		topologicalSort(indegree, array);
		
	}

	private static void topologicalSort(int[] indegree, List<List<Integer>> array) {
		Queue<Integer> q = new LinkedList<Integer>();
		Queue<Integer> result = new LinkedList<Integer>();
		
		for (int i = 0; i < N; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int node = q.poll();
			result.offer(node + 1);
			
			for (Integer i : array.get(node)) {
				indegree[i]--;
				
				if (indegree[i] == 0) {
					q.offer(i);
				}
			}
		}
		
		System.out.println(result);
		
	}

}
