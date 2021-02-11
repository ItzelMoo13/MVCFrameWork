package exceptions;

public class NonExistentTransaction extends Exception {
	  private static final long serialVersionUID = 1L;

	  public NonExistentTransaction(String message) {
	    super("NonExistentTransaction");
	  }
	}