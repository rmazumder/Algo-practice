public class BruteForceSort {
	
	

	public static void main(String[] args){

			int array[] = new int[]{21,23,11,3,445};

			System.out.println();
			System.out.print("UnSorted array : ");
			for (int a : array) {

				System.out.print(a + " ");
				
			}


			for (int i =0 ;i < array.length  ; i++ ) {


				for (int j=0; j<array.length; j++) {
					
					 if(j != array.length - 1 && array[i] > array[j + 1]){

						//swap
						int a = array[i];
						int b = array[j + 1];

						array[i] = b;
						array[j + 1] = a;

					}
				}
			}
				

			System.out.println();
			System.out.print("Sorted array : ");
			for (int a : array) {

				System.out.print(a + " ");
				
			}
			
	}
	
	  

		

	
	
	
	
}