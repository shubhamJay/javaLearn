package java.com.thoughtworks;

import org.junit.Test;

import java.Account;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AccountTest {
  @Test
  public void checkBalance(){
    Account acc;
    acc = new Account("123", 1000);
    assertThat(acc.getBalance(), is(1000));
  }

}