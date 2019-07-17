package basicsorting;

import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		Integer[] numArr = { 10, 3, 4, 15, 7, 9, 1, 21 };
		String[] strArr = { "claude", "Phil", "lois", "clark", "Arthur", "Mera", "bruce" };
		
		// created an Integer object from the generic abstract method in the
		// BasicSorter interface and assigns it to a block of code lambda expression
		// that uses a switch statement to chose between sorting in ascending order or
		// descending order
		BasicSorter<Integer> intSort = (a, s, c) -> {		
			Integer[] arr = a;
			switch(s) {
			case "ASC":
				Arrays.sort(arr);
				break;
			case "DESC":
				Arrays.sort(arr, Collections.reverseOrder());
				break;
			}
			
			return arr;
		};
		
		// created an String object from the generic abstract method in the
		// BasicSorter interface and assigns it to a block of code lambda expression
		// that uses a switch statement to chose between sorting in ascending order or
		// descending order or case insensitive or not
		BasicSorter<String> strSort = (a, s, c) -> {		
			boolean cases = c;
			String[] arr2 = a;
			switch(s) {
			case "ASC":
				if(cases == true) {
					// sorts the array passed in ascending order and ignores
					// the cases
					Arrays.sort(arr2, String.CASE_INSENSITIVE_ORDER);
				} else if (cases == false) {
					Arrays.sort(arr2);
				}
				break;
			case "DESC":
				if(cases == true) {
					Arrays.sort(arr2, String.CASE_INSENSITIVE_ORDER);
					Collections.reverse(Arrays.asList(arr2));
				} else if(cases == false) {
					Arrays.sort(arr2, Collections.reverseOrder());
				}
				break;
			}
			if(s.equals("DESC") && cases == true) {
				Arrays.sort(arr2, String.CASE_INSENSITIVE_ORDER);
				Collections.reverse(Arrays.asList(arr2));
			} else if(s.equals("ASC") && cases == true) {
				Arrays.sort(arr2, String.CASE_INSENSITIVE_ORDER);
			}
			return arr2;
		};
		
		System.out.println("Initial Integer Array " + Arrays.toString(numArr) + "\n");
		// assigns the lambda expression passing 3 parameters to the numArr Integer array
		numArr = intSort.basicSort(numArr, "ASC", false);
		// prints the integer array in ascending order
		System.out.println("Sorted ASC: " + Arrays.toString(numArr) + "\n");
		// assigns the lambda expression passing 3 parameters to the numArr Integer array
		numArr = intSort.basicSort(numArr, "DESC", false);
		// prints the integer array in descending order
		System.out.println("Sorted DESC: " + Arrays.toString(numArr) + "\n\n");
		
		System.out.println("Initial String Array " + Arrays.toString(strArr) + "\n");
		// assigns the lambda expression passing 3 parameters to the strArr String array
		strArr = strSort.basicSort(strArr, "ASC", false);
		// factors in the ASCII character codes when printing the String array in ascending order
		System.out.println("Sorted ASC(case insensitive: OFF): " + Arrays.toString(strArr) + "\n");
		// assigns the lambda expression passing 3 parameters to the strArr String array
		strArr = strSort.basicSort(strArr, "ASC", true);
		// ignores ASCII character codes and outputs the String array in ascending order
		System.out.println("Sorted ASC(case insensitive: ON): " + Arrays.toString(strArr) + "\n");
		// assigns the lambda expression passing 3 parameters to the strArr String array
		strArr = strSort.basicSort(strArr, "DESC", false);
		// factors in the ASCII character codes when printing the String array in descending order
		System.out.println("Sorted DESC(case insensitive: OFF): " + Arrays.toString(strArr) + "\n");
		// assigns the lambda expression passing 3 parameters to the strArr String array
		strArr = strSort.basicSort(strArr, "DESC", true);
		// ignores ASCII character codes and outputs the String array in descending order
		System.out.println("Sorted DESC(case insensitive: ON): " + Arrays.toString(strArr) + "\n");
	}// End of main
}// End of class
