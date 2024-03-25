package commands;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * GUI Implementation of the ViewInterface interface. It features buttons a text field and a label.
 */
public class View extends JFrame implements ViewInterface {
  private final JLabel display;
  private final JButton echoButton;
  private final JButton exitButton;
  private final JButton toggleButton;
  private final JButton makeUppercaseButton;
  private final JButton restoreOriginalTextButton;
  private final JButton flipTextButton;
  private final JTextField input;

  private ControllerInterface controllerFeatures;

  /**
   * Initialize the window.
   *
   * @param caption Caption for the window.
   */
  public View(String caption) {
    super(caption);

    setSize(500, 300);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new FlowLayout());


    display = new JLabel("To be displayed");

    this.add(display);

    // The textfield.
    input = new JTextField(10);
    this.add(input);

    // Echo button.
    echoButton = new JButton("Echo");
    echoButton.setActionCommand("Echo Button");
    this.add(echoButton);

    // Toggle color button.
    toggleButton = new JButton("Toggle color");
    toggleButton.setActionCommand("Toggle color");
    this.add(toggleButton);

    // Make Uppercase button.
    makeUppercaseButton = new JButton("Make Uppercase");
    makeUppercaseButton.setActionCommand("Make Uppercase");
    this.add(makeUppercaseButton);

    // Restore Original text button.
    restoreOriginalTextButton = new JButton("Restore text");
    restoreOriginalTextButton.setActionCommand("Restore text");
    this.add(restoreOriginalTextButton);

    // Flip text button.
    flipTextButton = new JButton("Flip text");
    flipTextButton.setActionCommand("Flip text");
    this.add(flipTextButton);

    //exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    this.add(exitButton);

    pack();
    setVisible(true);


  }

  @Override
  public void addFeatures(ControllerInterface controllerFeatures) {
    this.controllerFeatures = controllerFeatures;
    echoButton.addActionListener(evt -> controllerFeatures.echoOutput(input.getText()));
    toggleButton.addActionListener(evt -> controllerFeatures.toggleColor());
    makeUppercaseButton.addActionListener(evt -> {
      this.toggleUpperCase();
    });
    restoreOriginalTextButton.addActionListener(evt -> controllerFeatures.restoreToOriginalText());
    flipTextButton.addActionListener(evt -> {
      this.toggleFlipText();
    });
    exitButton.addActionListener(evt -> controllerFeatures.exitProgram());
    this.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 't') {
          controllerFeatures.toggleColor();
        }
      }

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
          toggleUpperCase();
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
          controllerFeatures.restoreToOriginalText();
        }
      }
    });
    updateView();
  }

  /*
    In order to make this frame respond to keyboard events, it must be within strong focus.
    Since there could be multiple components on the screen that listen to keyboard events,
    we must set one as the "currently focussed" one so that all keyboard events are
    passed to that component. This component is said to have "strong focus".

    We do this by first making the component focusable and then requesting focus to it.
    Requesting focus makes the component have focus AND removes focus from whoever had it
    before.
  */
  @Override
  public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

  @Override
  public void toggleColor() {
    if (this.display.getForeground().equals(Color.RED)) {
      this.display.setForeground(Color.BLACK);
    } else {
      this.display.setForeground(Color.RED);
    }
  }


  @Override
  public void setEchoOutput(String text) {
    display.setText(text);
    updateView();
  }

  @Override
  public String getInputString() {
    return input.getText();
  }

  @Override
  public void clearInputString() {
    input.setText("");
  }

  private void toggleUpperCase() {
    boolean isUpperCase = controllerFeatures.getUpperCase();

    controllerFeatures.setUpperCase(!isUpperCase);


    updateView();

  }

  // TODO this method is currently relying on the controller to do the work.
  // TODO change this to call setFlip to the controller.
  // TODO first call the controller to get the current flip state
  // TODO then call the controller to set the flip state to the opposite of the current state
  // TODO you probably want to call updateView() after you call the controller to set the flip state
  private void toggleFlipText() {
    // See avove.
    controllerFeatures.flipText();
  }

  private void updateView() {
    // Update the buttons that depend on model state
    if (controllerFeatures.getUpperCase()) {
      makeUppercaseButton.setText("Make Regular");
      //
    } else {
      makeUppercaseButton.setText("Make Uppercase");
    }

    // TODO update the flipTextButton text based on the controller's flip state
    // TODO see how we did it for upper case.

  }

}
