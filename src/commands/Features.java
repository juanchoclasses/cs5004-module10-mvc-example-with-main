package commands;

/**
 * Interface for an asynchronous controller. The user chooses the order of the commands.
 */
public interface Features {

  /**
   * Provide view with all the callbacks.
   *
   * @param v the view.
   */
  void setView(View v);

  /**
   * Toggle the color of the string.
   */
  void toggleColor();

  /**
   * Convert the String characters to upper case.
   */
  void makeUppercase();

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
