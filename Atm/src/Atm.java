import javax.swing.*;

public class Atm {
    private BankAccount account;
    private JFrame frame;
    private JTextField amountField;
    private JLabel balanceLabel;

    public Atm(BankAccount account) {
        this.account = account;
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("ATM Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel amountLabel = new JLabel("Enter amount:");
        amountField = new JTextField(10);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(amountField.getText());
                withdraw(amount);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a number.");
            }
        });

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(e -> {
            try {
                int amount = Integer.parseInt(amountField.getText());
                deposit(amount);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid amount. Please enter a number.");
            }
        });

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.addActionListener(e -> checkBalance());

        balanceLabel = new JLabel("Balance: " + account.getBalance());

        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(checkBalanceButton);
        panel.add(balanceLabel);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public void withdraw(int amount) {
        if (account.withdraw(amount)) {
            JOptionPane.showMessageDialog(frame, "Withdrawal successful.");
            updateBalanceLabel();
        } else {
            JOptionPane.showMessageDialog(frame, "Insufficient balance.");
        }
    }

    public void deposit(int amount) {
        account.deposit(amount);
        JOptionPane.showMessageDialog(frame, "Deposit successful.");
        updateBalanceLabel();
    }

    public void checkBalance() {
        JOptionPane.showMessageDialog(frame, "Your balance is: " + account.getBalance());
    }

    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: " + account.getBalance());
    }
}

