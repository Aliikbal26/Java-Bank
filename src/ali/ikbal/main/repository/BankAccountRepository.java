package ali.ikbal.main.repository;

import java.util.Collection;

import ali.ikbal.main.entity.EntityBankAccount;

public interface BankAccountRepository {
    /**
     * method method yang akan digunakan
     */

    Collection<EntityBankAccount> getAllBankAccounts(); // New method

    EntityBankAccount getBankAccountByNumber(String accountNumber);

    void updateBankAccount(EntityBankAccount bankAccount);

    void addBankAccount(EntityBankAccount... bankAccounts); // Add this method to the interface

}
