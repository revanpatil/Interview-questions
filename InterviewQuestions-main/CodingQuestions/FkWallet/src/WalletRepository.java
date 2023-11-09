import java.util.List;

public interface WalletRepository {
    void addTransaction(String accountHolder, String transaction);
    Wallet getWallet(String accountHolder);
    List<Wallet> getAllWallets();
    void createWallet(String accountHolder, double initialAmount, int id);
}
