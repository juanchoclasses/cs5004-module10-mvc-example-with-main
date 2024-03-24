import commands.Controller;
import commands.ModelImpl;
import commands.FrameView;

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
    ModelImpl model = new ModelImpl();

    FrameView view = new FrameView("5004 MVC Example");

    Controller controller = new Controller(model);
    controller.setView(view);


  }
}
