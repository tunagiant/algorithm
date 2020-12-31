package sort;
//O(N^2)
public class select {
	
	public static void main(String[] args) {
		
		int MIN = 0;
		int index = 0;
		int temp = 0;
		
		int[] array = { 1, 10, 5, 8, 7, 6, 4, 3, 2, 9 };
		
		for (int i = 0; i < 10; i++) {
			MIN = 100;
			for (int j = i; j < 10; j++) {
				if (MIN > array[j]) {
					MIN = array[j];
					index = j;
				}
			}
			temp = array[i];
			array[i] = array[index];
			array[index] = temp;
			
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(array[i]);
		}
		
	}

}
