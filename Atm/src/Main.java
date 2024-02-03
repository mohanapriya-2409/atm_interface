public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        Atm atm = new Atm(account);
        System.out.println("Thank You!!");
    }
}