package sort;

public class counting {
	
	public static void main(String[] args) {
		
		int[] array = { 1, 2, 3, 4, 1, 2, 3, 1, 3, 2, 3, 1, 5, 2, 5, 3, 1, 5, 2, 3, 4, 1, 5, 3 };
		int[] count = new int[6];
		
		for (int i = 0; i < array.length; i++) {
			count[array[i]]++;
		}
		
		for (int i = 1; i < count.length; i++) {
			if (count[i] != 0) {
				for (int j = 0; j < count[i]; j++) {
					System.out.print(i + " ");
				}
			}
		}
	}

}
