public class Bank {
  private String name;
  private Account accounts[];

  public static void main (String array[]){
    Account a = new Account(new String("shubham"),123);
    System.out.println(a.getHolderName());
    a.credit(300);
    System.out.println(a.getBalance());
  }
}