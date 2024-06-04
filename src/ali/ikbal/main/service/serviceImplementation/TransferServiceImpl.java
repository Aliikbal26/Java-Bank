package ali.ikbal.main.service.serviceImplementation;

import ali.ikbal.main.entity.EntityBankAccount;
import ali.ikbal.main.repository.BankAccountRepository;
import ali.ikbal.main.service.TransferService;

public class TransferServiceImpl implements TransferService {

    BankAccountRepository bankAccountRepository;

    public TransferServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public boolean transfer(String accountNumber, String toAccountNumber, double amount) {

        EntityBankAccount fromBankAccount = bankAccountRepository.getBankAccountByNumber(accountNumber);
        EntityBankAccount toBankAccount = bankAccountRepository.getBankAccountByNumber(toAccountNumber);

        if (accountNumber != null && toAccountNumber != null && fromBankAccount.getBalance().getAmount() >= amount) {
            double newFromBalance = fromBankAccount.getBalance().getAmount() - amount;
            double newToBalance = toBankAccount.getBalance().getAmount() + amount;

            fromBankAccount.getBalance().setAmount(newFromBalance);
            toBankAccount.getBalance().setAmount(newToBalance);

            bankAccountRepository.updateBankAccount(fromBankAccount);
            bankAccountRepository.updateBankAccount(toBankAccount);

            return true;
        }

        return false;
    }

}
