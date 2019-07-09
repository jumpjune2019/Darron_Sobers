package matrixcustomhandler;

public class WrongKeySelectedException extends Exception {

	int n;
	
	public WrongKeySelectedException(int i) {
		n = i;
	}
	
	public String toString() {
		return n + " is not 1, 2, or 3. Please use the options provided.";
	}

}

class MatrixOutOfBoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public MatrixOutOfBoundException(String error) {
		super(error);
	}
}