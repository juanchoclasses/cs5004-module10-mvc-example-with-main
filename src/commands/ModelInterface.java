package commands;

/**
 * ModelInterface interface for a very simple MVC example. We have methods to get and set a String.
 */
public interface ModelInterface {


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
   * Set the flip status.
   *
   * @param flip the flip status
   */
  void setFlip(boolean flip);

  /**
   * Get the flip status.
   *
   * @return the flip status
   */
  boolean getFlip();
  
}
