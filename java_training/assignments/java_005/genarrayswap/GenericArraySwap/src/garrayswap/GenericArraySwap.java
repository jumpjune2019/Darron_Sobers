package garrayswap;

public class GenericArraySwap {
	
	// generic method allows you to swap indices in an array
	public static <T> void swap(T[] a, int i, int j) {
		// uses a temporary variable to store the overridden index
		T temp = a[i];
		// a[i] is overridden by the value of a[j]
		a[i] = a[j];
		// a[j] is assigned to the temporary variable that help a[i]'s previous value
		a[j] = temp;
		System.out.printf("You have successfully switched elements %d and %d\n\n", i,j);
		
	}// End of swap()

	public static void main(String[] args) {
		// created a wrapper class character array to use generic method
		Character[] charArray = {'D','e','r','o','n'};
		
		System.out.println("Before swap method is called...\n");
		// prints out the array before swap is called
		for(char i : charArray) {
			System.out.print(i);
		}
		System.out.println("\n\nAfter swap method is called...\n");
		swap(charArray, 0, 4);
		// prints out the array after swap is called
		for(char i : charArray) {
			System.out.print(i);
		}

	}// End of main
}// End of class
