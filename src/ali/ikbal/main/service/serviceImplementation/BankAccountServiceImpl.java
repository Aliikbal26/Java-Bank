package ali.ikbal.main.service.serviceImplementation;

import ali.ikbal.main.entity.EntityBankAccount;
import ali.ikbal.main.repository.BankAccountRepository;
import ali.ikbal.main.service.BankAccountService;

public class BankAccountServiceImpl implements BankAccountService {

    private BankAccountRepository repository;

    public BankAccountServiceImpl(BankAccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public EntityBankAccount showBankAccount(String accountNumber) {
        return repository.getBankAccountByNumber(accountNumber);
    }

}
