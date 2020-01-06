
package sort;

public class BubbleSort {
	
	

	public static void main(String[] args){
		

		int array[] = new int[]{12,1,3,7,45,22, 14};

		System.out.println("Unsorted:");
		for (int a : array) {
			System.out.print(a +", ") ;
		}
		System.out.println();

		boolean swapneeded = true;
		boolean swappedDone = false;

		while(swapneeded){
			for (int i=0;i<array.length; i ++ ){
				if(i != array.length - 1){
					int a = array[i];
					int b = array[i + 1];

					if(a > b){ // needs swap
						swappedDone = true;
						array[i] = b;
						array[i + 1] = a ;
					}
				}

			}

			if(!swappedDone){
				swapneeded = false;
			}
			//reset swappedDone
			swappedDone = false;

		}


		System.out.println("Sorted:");
		for (int a : array) {
			System.out.print(a +", ") ;
		}


	}	
}