package exceptions;

public class NonExistentModelException extends Exception {
  private static final long serialVersionUID = 1L;

  public NonExistentModelException(String modelClassName) {
    super("The Model of the class " + modelClassName + " was not found in the classpath");
  }
}