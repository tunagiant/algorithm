package sort;
//O(N^2)
public class insertion {
	
	public static void main(String[] args) {
		
		int[] array = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
		
		for (int i = 0; i < 9; i++) {
			int j = i;
			while (j >= 0 && array[j] > array[j + 1]) {
				int temp = array[j + 1];
				array[j + 1] = array[j];
				array[j] = temp;
				j--;
			}
			
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(array[i]);
		}
		
	}

}
