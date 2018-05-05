import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

  @Test
  public void credit() {
    Account alex = new Account("alex",100);
    assertEquals(alex.getHolderName(),"alex");
    alex.credit(300);
    assertEquals("check that balance creadited",alex.getBalance(),200);
  }
}