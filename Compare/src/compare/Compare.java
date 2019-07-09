package compare;

import java.io.IOException;
import java.io.FileReader;

public class Compare {

	public static void main(String[] args) {
		int a;
		int b;
	
		try(
				FileReader f1 = new FileReader("C:\\Projects\\springbootprojects\\java_assignments\\assignments\\java_003\\Compare\\src\\compare\\file1.txt");
				FileReader f2 = new FileReader("C:\\Projects\\springbootprojects\\java_assignments\\assignments\\java_003\\Compare\\src\\compare\\file2.txt");
			) {
			
			int countA = 0;
			int countB = 0;
			

		    while (f1.read() != -1) {
		    	countA++;
		    }
		    while (f2.read() != -1) {
		    	countB++;
		    }
		    
		    if(countA == countB) {
		    	System.out.println("Result: identical content");
		    	System.out.println("character length for both " + countA);
		    } else {
		    	System.out.println("Result: different content");
		    	System.out.println("character length for file1.txt " + countA);
		    	System.out.println("character length for file2.txt " + countB);
		    }
		    
		f1.close();
		f2.close();
	} catch(IOException ex) {
		System.out.print(ex);
	}
	}
}
