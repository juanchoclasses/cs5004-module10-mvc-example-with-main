package commands;

/**
 * Implementation of the Model Interface.
 */
public class ModelImpl implements Model {
  private String input;

  public ModelImpl() {
    input = "";
  }

  @Override public void setString(String text) {
    input = text;
  }

  @Override public String getString() {
    return input;
  }

  @Override public String flipString() {
    StringBuilder inverted = new StringBuilder();
    for (int index = 0; index < this.input.length(); index++) {
      inverted.append(this.input.charAt(this.input.length() - 1 - index));
    }
    return inverted.toString();
  }

}