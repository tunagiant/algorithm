package sort;
//O(N * logN)

public class merge {
	public static int[] src;
	public static int[] tmp;

	public static void main(String[] args) {
		src = new int[] { 1, 9, 8, 5, 4, 2, 3, 7, 6 };
		tmp = new int[src.length];
		printArray(src);
		mergeSort(0, src.length - 1);
		printArray(src);
	}

	public static void mergeSort(int start, int end) {
		// 단위가 한개인 것 방지. 최소단위 두개부터 시작
		if (start < end) {
			int mid = (start + end) / 2;
			// 재귀
			mergeSort(start, mid);
			mergeSort(mid + 1, end);
			int p = start;
			int q = mid + 1;
			int idx = p;
			while (p <= mid || q <= end) {
/* 오른쪽분할의 원소를 다 쓴 경우 || 왼쪽분할에 원소가 있고, 오른쪽분할의 원소보다 작을경우
 * 왼쪽분할의 원소를 tmp에 채워넣는다. 아닐 시, 오른쪽분할의 원소를 tmp에 채워넣는다.
 * idx 는 재귀함수 호출에 따라 0부터 end까지 순차적으로 증가함
 */
				if (q > end || (p <= mid && src[p] < src[q])) {
					tmp[idx++] = src[p++];
				} else {
					tmp[idx++] = src[q++];
				}
			}
			
			// 임시배열 tmp를 src에 다시 넣는 과정(재귀에 따라 여러번 갱신됨)
			for (int i = start; i <= end; i++) {
				src[i] = tmp[i];
			}
		}
	}

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();

	}

}
