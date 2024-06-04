package ali.ikbal.main.entity;

public class EntityBankAccount {

    private String accountNumber;
    private String pin;
    private EntityBalance balance;

    public EntityBankAccount(String accountNumber, String pin, EntityBalance balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public EntityBalance getBalance() {
        return balance;
    }
}
