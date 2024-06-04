package ali.ikbal.main.service;

import ali.ikbal.main.entity.EntityPaymentPulsa;

public interface PaymentPulsaService {

    EntityPaymentPulsa showAmountPhone(String phoneNumber);

    void buyPulsa(String phoneNumber, double amount);

}
