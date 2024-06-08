package ali.ikbal.main.repository.repositoryImplementation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ali.ikbal.main.entity.EntityBalance;
import ali.ikbal.main.entity.EntityBankAccount;
import ali.ikbal.main.repository.BankAccountRepository;

public class BankAccountRepositoryImpl implements BankAccountRepository {

    private Map<String, EntityBankAccount> bankAccountMap = new HashMap<>();

    public BankAccountRepositoryImpl() {
        // Hardcoding some data into the repository
        EntityBankAccount account1 = new EntityBankAccount("123456", "1111", new EntityBalance(100000.0, "123456"));
        EntityBankAccount account2 = new EntityBankAccount("654321", "2222", new EntityBalance(200000.0, "654321"));
        addBankAccount(account1, account2);
    }

    @Override
    public void addBankAccount(EntityBankAccount... bankAccounts) {
        for (EntityBankAccount bankAccount : bankAccounts) {
            bankAccountMap.put(bankAccount.getAccountNumber(), bankAccount);
        }
    }

    @Override
    public Collection<EntityBankAccount> getAllBankAccounts() {
        return bankAccountMap.values();
    }

    @Override
    public EntityBankAccount getBankAccountByNumber(String accountNumber) {
        return bankAccountMap.get(accountNumber);
    }

    @Override
    public void updateBankAccount(EntityBankAccount bankAccount) {
        bankAccountMap.put(bankAccount.getAccountNumber(), bankAccount);
    }

}
