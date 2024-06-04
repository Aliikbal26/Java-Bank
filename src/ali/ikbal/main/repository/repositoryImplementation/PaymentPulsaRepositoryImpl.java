package ali.ikbal.main.repository.repositoryImplementation;

import ali.ikbal.main.entity.EntityPaymentPulsa;
import ali.ikbal.main.repository.PaymentPulsaRepository;

public class PaymentPulsaRepositoryImpl implements PaymentPulsaRepository {

    private EntityPaymentPulsa[] storage = new EntityPaymentPulsa[100];
    private int currentIndex = 0;

    @Override
    public EntityPaymentPulsa findByPhoneNumber(String phoneNumber) {
        for (int i = 0; i < currentIndex; i++) {
            if (storage[i].getPhoneNumber().equals(phoneNumber)) {
                return storage[i];
            }
        }
        return null;
    }

    @Override
    public void save(EntityPaymentPulsa entityPaymentPulsa) {
        for (int i = 0; i < currentIndex; i++) {
            if (storage[i].getPhoneNumber().equals(entityPaymentPulsa.getPhoneNumber())) {
                storage[i] = entityPaymentPulsa;
                return;
            }
        }
        if (currentIndex < storage.length) {
            storage[currentIndex++] = entityPaymentPulsa;
        }
    }

}
