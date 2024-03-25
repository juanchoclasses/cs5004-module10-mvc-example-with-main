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

    if (flip) {
      // TODO make sure you understand this line of code.
      result = new StringBuilder(result).reverse().toString();
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


}