import com.sun.prism.shader.Solid_TextureYV12_Loader;

public class Account {
  private String holderName;
  private int number;

  private int balance = 0;

  public Account(String holderName,int number) {
    this.holderName = holderName;
    this.number = number;
  }

  public static void main(String args[]){
   Account a =new Account("shubham",112);
   System.out.println(a.getHolderName());
   System.out.println("Account");
  }

  public int credit(int amount){
    balance += amount;
    return this.balance;
  }

  public String getHolderName() {
    return holderName;
  }

  public int getNumber() {
    return number;
  }

  public int getBalance() {
    return balance;
  }
}

