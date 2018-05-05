
import com.thoughtworks.step.bootcamp.CustomRectangle;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

//ensures created shape has properties of rectangle
public class CustomRectangleTest {
  CustomRectangle customRectangle;
  @Before
  public void setUp() {
    customRectangle = CustomRectangle.createRectangle(12, 5);
  }
  
  @Test
  public void shouldCalculateArea() {
    assertThat(customRectangle.area(),is(60.0));
  }
  
  @Test
  public void shouldCalculatePerimeter() {
    assertThat(customRectangle.perimeter(),is(34.0));
  }
  
}
