import java.util.*;
class WalletServiceImpl implements WalletService {
    private WalletRepository walletRepository;

    static int id = 1;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public void createWallet(String accountHolder, double initialAmount) {
        walletRepository.createWallet(accountHolder, initialAmount, id);
        id++;
    }

    @Override
    public void transferMoney(String sender, String receiver, double amount) {
        Wallet senderWallet = walletRepository.getWallet(sender);
        Wallet receiverWallet = walletRepository.getWallet(receiver);

        if (senderWallet != null && receiverWallet != null) {
            if (amount >= 0.0001 && amount <= senderWallet.getBalance()) {
                senderWallet.updateBalance(-amount);
                receiverWallet.updateBalance(amount);

                String senderTransaction = sender + " debit " + amount;
                String receiverTransaction = receiver + " credit " + amount;

                walletRepository.addTransaction(sender, senderTransaction);
                walletRepository.addTransaction(receiver, receiverTransaction);

                //Checking for the offer1 as the transaction is now complete
                if (senderWallet.getBalance() == receiverWallet.getBalance()) {
                    senderWallet.updateBalance(10);
                    receiverWallet.updateBalance(10);

                    walletRepository.addTransaction(sender, "Offer1 credit 10");
                    walletRepository.addTransaction(receiver, "Offer1 credit 10");
                }
            } else {
                System.out.println("Error: Invalid transfer amount.");
            }
        } else {
            System.out.println("Error: Invalid sender or receiver account.");
        }
    }

    @Override
    public void printStatement(String accountHolder) {
        Wallet wallet = walletRepository.getWallet(accountHolder);
        if (wallet != null) {
            List<String> transactions = wallet.getTransactions();
            System.out.println("Number of transactions for " + wallet.getAccountHolder() + " = " + transactions.size());
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Error: Invalid account holder.");
        }
    }

    @Override
    public void overview() {
        List<Wallet> wallets = walletRepository.getAllWallets();
        for (Wallet wallet : wallets) {
            System.out.println(wallet.getAccountHolder() + " " + wallet.getBalance());
        }
    }

    @Override
    public void applyOffer2() {
        List<Wallet> sortedWallets = new ArrayList<>(walletRepository.getAllWallets());

        //Sort the wallets based on the total number of transations they have made
        sortedWallets.sort((a, b) -> {
            int compare = Integer.compare(b.getTransactions().size(), a.getTransactions().size());
            if (compare == 0) {
                compare = Double.compare(b.getBalance(), a.getBalance());
                if (compare == 0) {
                    return a.getId() > (b.getId()) ? 1 : -1;
                }
            }
            return compare;
        });

        for (int i = 0; i < 3 && i < sortedWallets.size(); i++) {
            Wallet wallet = sortedWallets.get(i);
            double reward = (i == 0) ? 10 : (i == 1) ? 5 : 2;
            wallet.updateBalance(reward);
            walletRepository.addTransaction(wallet.getAccountHolder(), "Offer2 credit " + reward);
        }
    }
}
