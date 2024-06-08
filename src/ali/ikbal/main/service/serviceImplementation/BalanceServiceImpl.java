package ali.ikbal.main.service.serviceImplementation;

import java.util.Collection;

import ali.ikbal.main.entity.EntityBankAccount;
import ali.ikbal.main.repository.BalanceRepository;
import ali.ikbal.main.repository.BankAccountRepository;
import ali.ikbal.main.service.BalanceService;

public class BalanceServiceImpl implements BalanceService {

    private BankAccountRepository bankAccountRepository;
    private BalanceRepository balanceRepository;

    public BalanceServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public BalanceServiceImpl(BankAccountRepository bankAccountRepository, BalanceRepository balanceRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.balanceRepository = balanceRepository;
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
        if (bankAccount != null) {
            double currentBalance = balanceRepository.getBalance().getAmount();
            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;
                balanceRepository.getBalance().setAmount(newBalance);
                bankAccountRepository.updateBankAccount(bankAccount);
                return newBalance;
            }
            return currentBalance;
        }
        return 0.0;
    }

    @Override
    public double deposit(String accountNumber, double amount) {
        EntityBankAccount bankAccount = bankAccountRepository.getBankAccountByNumber(accountNumber);
        if (bankAccount != null) {
            double currentBalance = balanceRepository.getBalance().getAmount();
            double newBalance = currentBalance + amount;
            balanceRepository.getBalance().setAmount(newBalance);
            bankAccountRepository.updateBankAccount(bankAccount);
            return newBalance;
        }
        return 0.0;
    }
}
