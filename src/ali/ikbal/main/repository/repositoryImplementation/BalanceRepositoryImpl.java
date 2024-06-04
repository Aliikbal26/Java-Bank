package ali.ikbal.main.repository.repositoryImplementation;

import ali.ikbal.main.entity.EntityBalance;
import ali.ikbal.main.repository.BalanceRepository;

public class BalanceRepositoryImpl implements BalanceRepository {

    EntityBalance entityBalance;

    public BalanceRepositoryImpl(EntityBalance entityBalance) {
        this.entityBalance = entityBalance;
    }

    @Override
    public EntityBalance getBalance() {
        return entityBalance;
    }

}
