import commands.ModelInterface;
import static org.junit.Assert.assertEquals;

import commands.Model;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the model.
 */
public class ModelTest {

  private ModelInterface m1;
  private ModelInterface m2;

  /**
   * Set up. Create two objects of type ModelInterface and set the string messages.
   */
  @Before
  public void setUp() {
    m1 = new Model();
    m2 = new Model();
    m1.setString("Hello, world!");
    m2.setString("You will never forget my name.");
  }

  /**
   * Test getString method.
   */
  @Test
  public void testGetString() {
    assertEquals("Hello, world!", m1.getString());
    assertEquals("You will never forget my name.", m2.getString());
  }

  @Test
  public void testUpperCase() {
    m1.setUpperCase(true);
    assertEquals("HELLO, WORLD!", m1.getString());
    m2.setUpperCase(true);
    assertEquals("YOU WILL NEVER FORGET MY NAME.", m2.getString());

    m1.setUpperCase(false);
    assertEquals("Hello, world!", m1.getString());
    m2.setUpperCase(false);
    assertEquals("You will never forget my name.", m2.getString());
  }

  @Test
  // TODO make the model implement the flip variable.  this test will pass if you do this
  public void testFlipString() {
    m1.setFlip(true);
    assertEquals("!dlrow ,olleH", m1.getString());
    m2.setFlip(true);
    assertEquals(".eman ym tegrof reven lliw uoY", m2.getString());

    m1.setFlip(false);
    assertEquals("Hello, world!", m1.getString());
    m2.setFlip(false);
    assertEquals("You will never forget my name.", m2.getString());
  }

  @Test
  // TODO make the model implement the combinaton of the two
  // TODO once you make the above test pass this one should pass as well
  public void testUpperCaseAndFlipString() {
    m1.setUpperCase(true);
    m1.setFlip(true);
    assertEquals("!DLROW ,OLLEH", m1.getString());
    m2.setUpperCase(true);
    m2.setFlip(true);
    assertEquals(".EMAN YM TEHGROF REVEN LLIW UOY", m2.getString());

    m1.setUpperCase(false);
    m1.setFlip(false);
    assertEquals("Hello, world!", m1.getString());
    m2.setUpperCase(false);
    m2.setFlip(false);
    assertEquals("You will never forget my name.", m2.getString());
  }


}
