package ali.ikbal.main.repository.repositoryImplementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ali.ikbal.main.entity.EntityBankAccount;
import ali.ikbal.main.repository.BankAccountRepository;

public class BankAccountRepositoryImpl implements BankAccountRepository {

    // private List<EntityBankAccount> bank = new ArrayList<>();
    private Map<String, EntityBankAccount> bankAccountMap = new HashMap<>();

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
