package commands;

/**
 * Model interface for a very simple MVC example. We have methods to get and set a String.
 */
public interface Model {


  /**
   * Set a new String.
   *
   * @param text the String we want to use
   */
  void setString(String text);

  /**
   * Get the String.
   *
   * @return the Echoed String
   */
  String getString();

  /**
   * Get the uppercase status.
   *
   * @return the uppercase status
   */
  boolean getUpperCase();

  /**
   * Set the uppercase status.
   *
   * @param upperCase the uppercase status
   */
  void setUpperCase(boolean upperCase);

  /**
   * Flip the String.
   *
   * @return the flipped String
   */
  String flipString();
}
