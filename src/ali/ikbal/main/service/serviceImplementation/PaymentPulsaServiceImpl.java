package ali.ikbal.main.service.serviceImplementation;

import ali.ikbal.main.entity.EntityPaymentPulsa;
import ali.ikbal.main.repository.PaymentPulsaRepository;
import ali.ikbal.main.service.PaymentPulsaService;

public class PaymentPulsaServiceImpl implements PaymentPulsaService {

    private PaymentPulsaRepository paymentPulsa;

    public PaymentPulsaServiceImpl(PaymentPulsaRepository paymentPulsa) {
        this.paymentPulsa = paymentPulsa;
    }

    @Override
    public void buyPulsa(String phoneNumber, double amount) {
        EntityPaymentPulsa numberPhone = paymentPulsa.findByPhoneNumber(phoneNumber);
        if (numberPhone != null) {
            double newAmount = numberPhone.getAmountPhone() + amount;
            numberPhone.setAmountPhone(newAmount);
            paymentPulsa.save(numberPhone);
        } else {
            EntityPaymentPulsa newPayment = new EntityPaymentPulsa();
            newPayment.setPhoneNumber(phoneNumber);
            newPayment.setAmountPhone(amount);
            paymentPulsa.save(newPayment);
        }
    }

    @Override
    public EntityPaymentPulsa showAmountPhone(String phoneNumber) {
        return paymentPulsa.findByPhoneNumber(phoneNumber);
    }

}
