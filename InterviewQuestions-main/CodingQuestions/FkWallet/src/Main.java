public class Main {
    public static void main(String[] args) {

        WalletRepository walletRepository = new WalletRepositoryImpl();
        WalletService walletService = new WalletServiceImpl(walletRepository);

        walletService.createWallet("Sameer", 95.7);
        walletService.createWallet("Pravallika", 104);
        walletService.createWallet("Charan", 200);
        walletService.createWallet("Anchal", 500);
        walletService.createWallet("Sadhana", 100);

        walletService.overview();
        System.out.println("---------------------------------------------");

        walletService.transferMoney("Charan", "Anchal", 30);
        walletService.transferMoney("Pravallika", "Sadhana", 2);
        walletService.transferMoney("Charan", "Sameer", 5);

        walletService.overview();
        System.out.println("---------------------------------------------");

        walletService.printStatement("Sadhana");
        System.out.println("---------------------------------------------");

        walletService.printStatement("Charan");
        System.out.println("---------------------------------------------");

        walletService.printStatement("Anchal");
        System.out.println("---------------------------------------------");

        walletService.printStatement("Pravallika");
        System.out.println("---------------------------------------------");

        walletService.printStatement("Sameer");
        System.out.println("---------------------------------------------");


        walletService.applyOffer2();
        walletService.overview();
    }
}