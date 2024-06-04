package ali.ikbal.main.service.serviceImplementation;

import ali.ikbal.main.entity.EntityPaymentToken;
import ali.ikbal.main.repository.PaymentTokenRepository;
import ali.ikbal.main.service.PaymentTokenService;

public class PaymentTokenServiceImpl implements PaymentTokenService {

    private PaymentTokenRepository paymentTokenRepository;

    public PaymentTokenServiceImpl(PaymentTokenRepository paymentTokenRepository) {
        this.paymentTokenRepository = paymentTokenRepository;
    }

    @Override
    public void buyToken(String idNumber, double amount) {
        EntityPaymentToken entityPaymentToken = paymentTokenRepository.findByIdToken(idNumber);
        if (entityPaymentToken != null) {
            double newAmount = entityPaymentToken.getAmountToken() + amount;
            entityPaymentToken.setAmountToken(newAmount);
            paymentTokenRepository.save(entityPaymentToken);
        } else {
            EntityPaymentToken newPaymentToken = new EntityPaymentToken();
            newPaymentToken.setTokenNumber(idNumber);
            newPaymentToken.setAmountToken(amount);
            paymentTokenRepository.save(newPaymentToken);
        }
    }

    @Override
    public EntityPaymentToken showAmountToken(String idNumber) {
        return paymentTokenRepository.findByIdToken(idNumber);
    }

}
