
public class Arrays {

	public static void main(String[] args) {

		int[] array1 = {1, 2, 3, 4, 5, 7, 11} ;
		int[] array2 =  {2, 3, 4, 5, 6, 8, 12} ;
		int value = 9;
		System.out.println(getCount(array1,array2, value));;
	}

	public static int getCount(int[] array, int[] array2, int value) {
		int counter=0;
		
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array2.length;j++) {
				if(array[i]+array2[j]==value)
					counter++;
			}
		}
		return counter;
	}
	
}
