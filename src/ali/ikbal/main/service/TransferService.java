package ali.ikbal.main.service;

public interface TransferService {
    boolean transfer(String accountNumber, String toAccountNumber, double amount);
}
