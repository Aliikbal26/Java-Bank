package ali.ikbal.main.service.serviceImplementation;

import java.util.Collection;

import ali.ikbal.main.entity.EntityBankAccount;
import ali.ikbal.main.repository.BankAccountRepository;
import ali.ikbal.main.service.BalanceService;

public class BalanceServiceImpl implements BalanceService {

    private BankAccountRepository bankAccountRepository;

    public BalanceServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public boolean validatePin(String pin) {
        Collection<EntityBankAccount> accounts = bankAccountRepository.getAllBankAccounts();
        for (EntityBankAccount account : accounts) {
            if (account.getPin().equals(pin)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double withdraw(String accountNumber, double amount) {
        EntityBankAccount bankAccount = bankAccountRepository.getBankAccountByNumber(accountNumber);
        if (bankAccount != null && bankAccount.getBalance().getAmount() >= amount) {
            double newBalance = bankAccount.getBalance().getAmount() - amount;
            bankAccount.getBalance().setAmount(newBalance);
            bankAccountRepository.updateBankAccount(bankAccount);
            return newBalance;
        }
        return bankAccount.getBalance().getAmount();
    }

    @Override
    public double deposit(String accountNumber, double amount) {
        EntityBankAccount bankAccount = bankAccountRepository.getBankAccountByNumber(accountNumber);
        if (bankAccount != null) {
            double newBalance = bankAccount.getBalance().getAmount() + amount;
            bankAccount.getBalance().setAmount(newBalance);
            bankAccountRepository.updateBankAccount(bankAccount);
            return newBalance;
        }
        return bankAccount.getBalance().getAmount();
    }
}
