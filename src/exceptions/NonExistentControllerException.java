package exceptions;

public class NonExistentControllerException extends Exception {
  private static final long serialVersionUID = 1L;

  public NonExistentControllerException(String controllerClassName) {
    super("The controller of the class: " + controllerClassName + " was not found in the classpath");
  }
}