package ali.ikbal.main.service;

public interface BalanceService {

    boolean validatePin(String pin);

    double withdraw(String accountNumber, double amount);

    double deposit(String accountNumber, double amount);

}
