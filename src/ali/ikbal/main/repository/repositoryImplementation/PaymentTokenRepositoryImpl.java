package ali.ikbal.main.repository.repositoryImplementation;

import ali.ikbal.main.entity.EntityPaymentToken;
import ali.ikbal.main.repository.PaymentTokenRepository;

public class PaymentTokenRepositoryImpl implements PaymentTokenRepository {

    private EntityPaymentToken[] storage = new EntityPaymentToken[100];
    private int currentIndex = 0;

    @Override
    public EntityPaymentToken findByIdToken(String idToken) {
        for (int i = 0; i < currentIndex; i++) {
            if (storage[i].getTokenNumber().equals(idToken)) {
                return storage[i];
            }
        }
        return null;
    }

    @Override
    public void save(EntityPaymentToken entityPaymentToken) {
        for (int i = 0; i < currentIndex; i++) {
            if (storage[i].getTokenNumber().equals(entityPaymentToken.getTokenNumber())) {
                storage[i] = entityPaymentToken;
                return;
            }
        }
        if (currentIndex < storage.length) {
            storage[currentIndex++] = entityPaymentToken;
        }
    }

}
