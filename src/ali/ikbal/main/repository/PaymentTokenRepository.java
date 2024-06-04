package ali.ikbal.main.repository;

import ali.ikbal.main.entity.EntityPaymentToken;

public interface PaymentTokenRepository {
    EntityPaymentToken findByIdToken(String idToken);

    void save(EntityPaymentToken entityPaymentToken);
}
