import com.thoughtworks.step.bootcamp.CustomRectangle;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CustomSquareTest {
  
  @Test
  public void shouldCalculateAreaForGivenOneSideOnly() {
    CustomRectangle square = CustomRectangle.createSquare(5);
    assertThat(square.area(),is(25.0));
  }
  
  @Test
  public void shouldCalculatePerimeterForGivenOnlyOneSide() {
    CustomRectangle square = CustomRectangle.createSquare(5);
    assertThat(square.perimeter(),is(20.0));
  }
}
