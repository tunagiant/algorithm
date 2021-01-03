package sort;

public class heap {
	private static int[] data;
	private static int number = 10;

	public static void heap(int[] data, int number) {
		for (int i = 1; i < number; i++) {
			int child = i;
			// index 0 : 최상위 root
			while (child > 0) {
				//  이진트리 : 부모index = 자식index - 1 / 2
				int parent = (child - 1) / 2;
				if (data[child] > data[parent]) {
					int temp = data[parent];
					data[parent] = data[child];
					data[child] = temp;
				}
				child = parent;
			}
		}
	}

	public static void main(String[] args) {
		
		data = new int[number];
		
		for (int i = 0; i < number; i++) {
			data[i] = (int) (Math.random() * 100);
		}
		
		System.out.print("정렬 전 : ");
		for (int i = 0; i < number; i++) {
			System.out.print(data[i] + " ");
		}
		
		heap(data, number);
		
		for (int i = number - 1; i > 0; i--) {
			int temp = data[0];
			data[0] = data[i];
			data[i] = temp;
			heap(data, i);
		}
		
		System.out.print("\n정렬 후 : ");
		
		for (int i = 0; i < number; i++) {
			System.out.print(data[i] + " ");
		}
	}
}
