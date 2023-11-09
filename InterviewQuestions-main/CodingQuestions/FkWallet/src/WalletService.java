public interface WalletService {
    void createWallet(String accountHolder, double initialAmount);
    void transferMoney(String sender, String receiver, double amount);
    void printStatement(String accountHolder);
    void overview();
    void applyOffer2();
}
