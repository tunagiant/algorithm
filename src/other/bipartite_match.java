package other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bipartite_match {
	static final int MAX_N = 1001;
	static int n, m;
	static boolean visit[] = new boolean[MAX_N];
	static int[] b = new int[MAX_N];
	static boolean[] c = new boolean[MAX_N];
	static ArrayList<Integer>[] ver = new ArrayList[MAX_N];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		ver[1].add(1);
		ver[1].add(2);
		ver[1].add(3);
		ver[2].add(1);
		ver[3].add(2);
		int count = 0;
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(c, false);
			if (dfs(i)) count++;
		}
		
	}

	static int bmatch() {
		int ret = 0;

		for (int i = 1; i <= n; i++) {
			Arrays.fill(visit, false);
			;
			if (dfs(i)) {
				ret++;
			}
		}
		return ret;
	}

	static boolean dfs(int here) {
		if (visit[here]) {
			return false;
		}

		visit[here] = true;

		for (int there : ver[here]) {
			if (b[there] == 0 || dfs(b[there])) {

				b[there] = here;
				return true;
			}
		}
		return false;
	}

}
