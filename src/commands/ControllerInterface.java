package commands;

/**
 * Interface for an asynchronous controller. The user chooses the order of the commands.
 */
public interface ControllerInterface {

  /**
   * Provide view with all the callbacks.
   *
   * @param v the view.
   */
  void setView(ViewInterface v);

  /**
   * Toggle the color of the string.
   */
  void toggleColor();

  /**
   * Convert the String characters to upper case.
   *
   * @param upperCase true if the characters should be upper case, false otherwise
   */
  void setUpperCase(boolean upperCase);

  /**
   * Get the upper case status of the text.
   *
   * @return true if the text is upper case, false otherwise
   */
  boolean getUpperCase();

  /**
   * set the flipText status.
   *
   * @param flipText true if the text should be flipped, false otherwise
   */

  void setFlipText(boolean flipText);

  /**
   * Get the flipText status.
   *
   * @return true if the text is flipped, false otherwise
   */
  boolean getFlipText();

  /**
   * get the text of the model.
   *
   * @return the text of the model
   */
  String getText();

  /**
   * Restore to the original capitalization of the text.
   */
  void restoreToOriginalText();

  /**
   * Flip the order of the characters in the String.
   */
  void flipText();

  /**
   * Echo the String entered by the user.
   *
   * @param typed the string entered by the user
   */
  void echoOutput(String typed);

  /**
   * Exit the program.
   */
  void exitProgram();
}
