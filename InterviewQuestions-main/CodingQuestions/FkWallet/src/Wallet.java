import java.util.List;

public interface Wallet {
    String getAccountHolder();
    double getBalance();
    List<String> getTransactions();
    void addTransaction(String transaction);
    void updateBalance(double amount);

    int getId();
}
