import java.util.ArrayList;
import java.util.List;

class WalletImpl implements Wallet {
    private String accountHolder;
    private double balance;
    private List<String> transactions;

    private int id;

    public WalletImpl(String accountHolder, double initialAmount, int id) {
        this.accountHolder = accountHolder;
        this.balance = initialAmount;
        this.transactions = new ArrayList<>();
        this.id = id;
    }

    @Override
    public String getAccountHolder() {
        return accountHolder;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<String> getTransactions() {
        return transactions;
    }

    @Override
    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    @Override
    public void updateBalance(double amount) {
        balance += amount;
    }

    @Override
    public int getId() {
        return id;
    }
}