import java.util.*;

class WalletRepositoryImpl implements WalletRepository {
    private Map<String, Wallet> wallets;

    public WalletRepositoryImpl() {
        this.wallets = new HashMap<>();
    }

    @Override
    public void addTransaction(String accountHolder, String transaction) {
        Wallet wallet = wallets.get(accountHolder);
        if (wallet != null) {
            wallet.addTransaction(transaction);
        } else {
            System.out.println("Error: Invalid account holder for transaction.");
        }
    }

    @Override
    public Wallet getWallet(String accountHolder) {
        return wallets.get(accountHolder);
    }

    @Override
    public List<Wallet> getAllWallets() {
        return new ArrayList<>(wallets.values());
    }

    @Override
    public void createWallet(String accountHolder, double initialAmount, int id) {
        if (!wallets.containsKey(accountHolder) && initialAmount >= 0) {
            Wallet wallet = new WalletImpl(accountHolder, initialAmount, id);
            wallets.put(accountHolder, wallet);
        } else {
            System.out.println("Error: Invalid account holder or initial amount or account already exists.");
        }
    }
}
