package exceptions;

public class NonExistentConfigFileException extends Exception {
  private static final long serialVersionUID = 1L;

  public NonExistentConfigFileException(String configFileName) {
    super("configuration file '" + configFileName + "' not found in the classpath");
  }
}
