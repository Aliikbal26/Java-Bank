package ali.ikbal.main.service;

import ali.ikbal.main.entity.EntityPaymentToken;

public interface PaymentTokenService {

    EntityPaymentToken showAmountToken(String idNumber);

    void buyToken(String idNumber, double amount);
}
