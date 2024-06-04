package ali.ikbal.main.repository;

import ali.ikbal.main.entity.EntityPaymentPulsa;

public interface PaymentPulsaRepository {

    EntityPaymentPulsa findByPhoneNumber(String phoneNumber);

    void save(EntityPaymentPulsa entityPaymentPulsa);

}
