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
 * GUI Implementation of the View interface. It features buttons a text field and a label.
 */
public class FrameView extends JFrame implements View {
  private final JLabel display;
  private final JButton echoButton;
  private final JButton exitButton;
  private final JButton toggleButton;
  private final JButton makeUppercaseButton;
  private final JButton restoreOriginalTextButton;
  private final JButton flipTextButton;
  private final JTextField input;

  /**
   * Initialize the window.
   *
   * @param caption Caption for the window.
   */
  public FrameView(String caption) {
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

  @Override public void addFeatures(Features features) {
    echoButton.addActionListener(evt -> features.echoOutput(input.getText()));
    toggleButton.addActionListener(evt -> features.toggleColor());
    makeUppercaseButton.addActionListener(evt -> features.makeUppercase());
    restoreOriginalTextButton.addActionListener(evt -> features.restoreToOriginalText());
    flipTextButton.addActionListener(evt -> features.flipText());
    exitButton.addActionListener(evt -> features.exitProgram());
    this.addKeyListener(new KeyListener() {
      @Override public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 't') {
          features.toggleColor();
        }
      }

      @Override public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
          features.makeUppercase();
        }
      }

      @Override public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_C) {
          features.restoreToOriginalText();
        }
      }
    });
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
  @Override public void resetFocus() {
    this.setFocusable(true);
    this.requestFocus();
  }

  @Override public void toggleColor() {
    if (this.display.getForeground().equals(Color.RED)) {
      this.display.setForeground(Color.BLACK);
    } else {
      this.display.setForeground(Color.RED);
    }
  }

  @Override public void setEchoOutput(String text) {
    display.setText(text);
  }

  @Override public String getInputString() {
    return input.getText();
  }

  @Override public void clearInputString() {
    input.setText("");
  }

}
