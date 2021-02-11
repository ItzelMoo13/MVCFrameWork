package exceptions;

public class IncorrectStructureException extends Exception {
	  private static final long serialVersionUID = 1L;

	  public IncorrectStructureException(String message) {
	    super(message);
	  }
}