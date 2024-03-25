package commands;

/**
 * Implementation of the ModelInterface Interface.
 */
public class Model implements ModelInterface {

  private boolean upperCase = false;
  private boolean flip = false;
  private String input;

  public Model() {
    input = "";
  }

  @Override
  public void setString(String text) {
    input = text;
  }

  @Override
  public String getString() {
    String result = input;

    if (getFlip()) {
      result = flipString(result);
    }

    if (upperCase) {
      result = result.toUpperCase();
    }
    return result;
  }


  @Override
  public boolean getUpperCase() {
    return upperCase;
  }

  @Override
  public void setUpperCase(boolean upperCase) {
    this.upperCase = upperCase;
  }

  @Override
  public void setFlip(boolean flip) {

    // TODO update the flip variable and set it here.
  }

  @Override
  public boolean getFlip() {
    // TODO check that you return the flip variable.
    return false;
  }


  private String flipString(String returnString) {
    StringBuilder inverted = new StringBuilder();
    for (int index = 0; index < returnString.length(); index++) {
      inverted.append(this.input.charAt(this.input.length() - 1 - index));
    }
    return inverted.toString();
  }

}