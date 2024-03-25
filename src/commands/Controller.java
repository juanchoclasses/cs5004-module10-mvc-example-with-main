package commands;

/**
 * Controller. Implementation of the ControllerInterface interface.
 */
public class Controller implements ControllerInterface {
  private final ModelInterface model;
  private ViewInterface view;

  /**
   * Constructor.
   *
   * @param m the ModelInterface.
   */
  public Controller(ModelInterface m) {
    model = m;
  }

  @Override
  public void setView(ViewInterface v) {
    view = v;
    view.addFeatures(this);
  }

  @Override
  public void toggleColor() {
    view.toggleColor();
  }

  @Override
  public boolean getUpperCase() {
    return model.getUpperCase();
  }

  @Override
  public void setUpperCase(boolean upperCase) {
    model.setUpperCase(upperCase);
    String text = model.getString();
    view.setEchoOutput(text);
  }

  @Override
  public void setFlipText(boolean flipText) {
    model.setFlip(flipText);
    String text = model.getString();
    view.setEchoOutput(text);
  }

  @Override
  public boolean getFlipText() {
    return model.getFlip();
  }

  @Override
  public void restoreToOriginalText() {
    model.setFlip(false);
    model.setUpperCase(false);
    String text = model.getString();
    view.setEchoOutput(text);
  }


  /**
   * Flip the text.
   *
   * This is functionality that should be in the model.
   */
  @Override
  public void flipText() {
    String text = model.getString();
    text = new StringBuilder(text).reverse().toString();

    view.setEchoOutput(text);
  }

  @Override
  public void echoOutput(String typed) {
    // Send text to the model.
    model.setString(typed);

    // Clear input textfield.
    view.clearInputString();

    // Finally echo the string in view.
    String text = model.getString();
    view.setEchoOutput(text);

    // Set focus back to main frame so that keyboard events work.
    view.resetFocus();
  }

  @Override
  public String getText() {
    return model.getString();
  }

  @Override
  public void exitProgram() {
    System.exit(0);
  }
}
