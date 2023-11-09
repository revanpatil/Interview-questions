 

Create a simple banking application. 

One user can own multiple bank accounts. Also, one account can be owned by multiple users (Joint account holders)  

The following operations can be performed on an account: 

Deposit money in an account. 

Withdraw money from an account. 

Get the current account balance. 

Get all the transactions that have happened on an account.  

Invariant: At any point in time, the balance in an account cannot be negative. 


Class User{
		//user details like name, email
}

Class Transactions{
	//transaction related fields like type, acc no, 
}


Class Account{
	
  private double balance;
  private List<Transaction> transactions;
  
  //Constructor 
  //getter and setter
  
  public void withdraw(double amount){
  
  }
  
  public List<Transaction> getTransaction(){
  
  }  
}

Class Bank{
private List<User> user;
//getter and setter
}



//////////////////////////




class User {

  private String userId;
  private String name;
  private List<Account> accounts = new ArrayList<>();

  User(String name) {
    this.userId = UUID.randomUUID().toString().substring(0, 8);
    this.name = name;
  }

  void add(Account account) {
    this.accounts.add(account);
  }

  @Override
  public String toString() {
    String accountIds
        = this.accounts.stream()
        .map(Account::getAccountId).collect(Collectors.joining(", "));
    return "User{" +
        "userId='" + this.userId + '\'' +
        ", name='" + this.name + '\'' +
        ", accounts='" + accountIds + '\'' +
        '}';
  }

}

class InvalidTransaction extends Exception {

  InvalidTransaction(String message, Throwable cause) {
    super(message, cause);
  }

}

enum TransactionType {
  DEBIT, CREDIT;
}

class Transaction {

  Transaction(TransactionType type, BigDecimal amount) {
    this.transactionRef = UUID.randomUUID().toString().substring(0, 8);
    this.type = Objects.requireNonNull(type);
    this.amount = Objects.requireNonNull(amount);
  }

  private String transactionRef;
  private TransactionType type;
  private BigDecimal amount;

  @Override
  public String toString() {
    return "Transaction{" +
        "transactionRef='" + this.transactionRef + '\'' +
        ", type=" + this.type +
        ", amount=" + this.amount +
        '}';
  }

  TransactionType getType() {
    return this.type;
  }

  BigDecimal getAmount() {
    return this.amount;
  }

}

interface Account {

  String getAccountId();

  List<User> getHolders();

  void register(User holder);

  Transaction deposit(BigDecimal money);

  Transaction withdraw(BigDecimal money) throws InvalidTransaction;

  BigDecimal getBalance();

  List<Transaction> getAllTransactions();

 
  void recompute();

}

class Savings implements Account {

  private String accountId;
  private List<User> holders = new ArrayList<>();
  private BigDecimal balance;
  private List<Transaction> transactions = new ArrayList<>();

  Savings() {
    this.accountId = UUID.randomUUID().toString().substring(0, 8);
    this.balance = BigDecimal.ZERO;
  }

  @Override
  public String getAccountId() {
    return this.accountId;
  }

  @Override
  public List<User> getHolders() {
    return this.holders;
  }

  @Override
  public void register(User holder) {
    this.holders.add(holder);
    holder.add(this);
  }

  @Override
  public Transaction deposit(BigDecimal money) {
    Transaction transaction = new Transaction(TransactionType.CREDIT, money);
    this.balance = this.balance.add(money);
    this.transactions.add(transaction);
    return transaction;
  }

  @Override
  public Transaction withdraw(BigDecimal money) throws InvalidTransaction {
    if (this.balance.compareTo(money) < 0) {
      throw new InvalidTransaction(
          "Cannot withdraw " + money + " as it is more than the current balance", null);
    }

    Transaction transaction = new Transaction(TransactionType.DEBIT, money);
    this.balance = this.balance.subtract(money);
    this.transactions.add(transaction);
    return transaction;
  }

  @Override
  public BigDecimal getBalance() {
    return this.balance;
  }

  @Override
  public List<Transaction> getAllTransactions() {
    return this.transactions;
  }

  public void recompute() {
    this.balance = BigDecimal.ZERO;
    this.transactions.forEach(this::apply);
  }

  private void apply(Transaction transaction) {
    if (TransactionType.CREDIT.equals(transaction.getType())) {
      this.balance = this.balance.add(transaction.getAmount());
    } else if (TransactionType.DEBIT.equals(transaction.getType())) {
      this.balance = this.balance.subtract(transaction.getAmount());
    }
  }

  @Override
  public String toString() {
    return "Savings{" +
        "accountId='" + accountId + '\'' +
        ", holders=" + holders +
        ", balance=" + balance +
        ", transactions=" + transactions +
        '}';
  }

}

public class BankingApplication {

  public static void main(String[] args) {
    User u1 = new User("User 1");
    User u2 = new User("User 2");

    Account a1 = new Savings();
    Account a2 = new Savings();

    a1.register(u1);
    a1.register(u2);

    a2.register(u1);

    a1.deposit(BigDecimal.valueOf(100));
    a1.deposit(BigDecimal.valueOf(200));
    a1.deposit(BigDecimal.valueOf(300));

    try {
      a1.withdraw(BigDecimal.valueOf(1000));
    } catch (InvalidTransaction it) {
      it.printStackTrace();
    }

    try {
      a1.withdraw(BigDecimal.valueOf(500));
    } catch (InvalidTransaction it) {
      it.printStackTrace();
    }

    System.out.println("Total transactions: " + a1.getAllTransactions().size());

    System.out.println("Current balance: " + a1.getBalance());
    a1.recompute();
    System.out.println("Balance after re-computation: " + a1.getBalance());

    System.out.println(a1);

  }

}
