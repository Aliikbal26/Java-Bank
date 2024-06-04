package ali.ikbal.main.entity;

public class EntityBalance {
    private String bankAccount;
    private double amount;

    public EntityBalance(double amount, String bankAccount) {
        this.amount = amount;
        this.bankAccount = bankAccount;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
