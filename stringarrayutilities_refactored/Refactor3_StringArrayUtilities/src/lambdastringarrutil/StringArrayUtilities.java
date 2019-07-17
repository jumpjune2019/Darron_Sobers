package lambdastringarrutil;

public class StringArrayUtilities {
	public static void main(String[] args) {
		BooleanUtil checkArr = (arr, str, bin) -> {
			if (bin == false) {
				str.toLowerCase();
			}
			
			for(int i = 0; i < arr.length; i++) {
				if (bin == false) {
					if (str.equals(arr[i].toLowerCase())) {
						return true;
					}
				}
				if (str.equals(arr[i])) {
					return true;
				}
			}
			return false;
		};
		
		IndexUtil checkIn = (arr, str, bin) -> {
			int occurances = 0;
			int[] foundIndexes = new int[1];
			if (bin == false) {
				str.toLowerCase();
			}
			
			for(int i = 0; i < arr.length; i++) {
				if (bin == false) {
					if (str.equals(arr[i].toLowerCase())) {
						foundIndexes[0]++;
						occurances++;
					}
				}
				if (str.equals(arr[i])) {
					foundIndexes[0]++;
					occurances++;
				}
				
			}
			if(occurances == 0) {
				return -1;
			}
			
			return foundIndexes[0];
		};

		String[] myList = {"Bozo", "FooBar", "Delta", "Foozball", "Demo", "Money", "Zoo", "Zoo"};
		System.out.println("This is the a test of the arrayHasExactMatch and indexOfOccurenceInArray methods");
		System.out.println("The array to test contains the following items");
		System.out.println("{\"Bozo\", \"FooBar\", \"Delta\", \"Foozball\", \"Demo\", \"Money\", \"Zoo\", \"Zoo\"}");
		System.out.println("Scenario 1\n" + "arrayHasExactMatch (myList, \"zo\", false): is " + checkArr.arrUtility(myList, "zo", false) + "\n");
		System.out.println("Scenario 2\n" + "arrayHasExactMatch (myList, \"zoo\", false): is " + checkArr.arrUtility(myList, "zoo", false) + "\n");
		System.out.println("Scenario 3\n" + "arrayHasExactMatch (myList, \"zoo\", true): is " + checkArr.arrUtility(myList, "zoo", true) + "\n");
		System.out.println("Scenario 4\n" + "arrayHasExactMatch (myList, \"foo\", true): is " + checkArr.arrUtility(myList, "foo", true) + "\n");
		System.out.println("Scenario 5\n" + "arrayHasExactMatch (myList, \"foo\", false): is " + checkArr.arrUtility(myList, "foo", false) + "\n");
		System.out.println("Scenario 6\n" + "arrayHasExactMatch (myList, \"delta\", true): is " + checkArr.arrUtility(myList, "delta", true) + "\n");
		System.out.println("Scenario 7\n" + "arrayHasExactMatch (myList, \"Delta\", true): is " + checkArr.arrUtility(myList, "Delta", true) + "\n");
		System.out.println("Second half of testing\n\n");
		System.out.println("Scenario 8\n" + "checkIn.inUtility (myList, \"zo\", false): is " + "[" +checkIn.inUtility(myList, "zo", false) + "]" + "\n");
		System.out.println("Scenario 9\n" + "checkIn.inUtility (myList, \"zoo\", false): is " + "[" +checkIn.inUtility(myList, "zoo", false) + "]" + "\n");
		System.out.println("Scenario 10\n" + "checkIn.inUtility (myList, \"zoo\", true): is " + "[" +checkIn.inUtility(myList, "zoo", true) + "]" + "\n");
		System.out.println("Scenario 11\n" + "checkIn.inUtility (myList, \"foo\", true): is " + "[" +checkIn.inUtility(myList, "foo", true) + "]" + "\n");
		System.out.println("Scenario 12\n" + "checkIn.inUtility (myList, \"foo\", false): is " + "[" +checkIn.inUtility(myList, "foo", false) + "]" + "\n");
		System.out.println("Scenario 13\n" + "checkIn.inUtility (myList, \"delta\", true): is " + "[" +checkIn.inUtility(myList, "delta", true) + "]" + "\n");
		System.out.println("Scenario 14\n" + "checkIn.inUtility (myList, \"Delta\", true): is " + "[" +checkIn.inUtility(myList, "Delta", true) + "]" + "\n");
	}

}
