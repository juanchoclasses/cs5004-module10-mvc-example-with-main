import commands.Controller;
import commands.Model;
import commands.View;

/**
 * The type Main. this holds the main method that runs the program.
 */
public class Main {

  /**
   * The main method.
   *
   * @param args the args
   */
  public static void main(String[] args) {
    Model model = new Model();

    View view = new View("5004 MVC Example");

    Controller controller = new Controller(model);
    controller.setView(view);


  }
}
