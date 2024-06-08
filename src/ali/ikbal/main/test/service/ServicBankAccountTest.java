package ali.ikbal.main.test.service;

import java.util.Scanner;

import ali.ikbal.main.repository.repositoryImplementation.BankAccountRepositoryImpl;
import ali.ikbal.main.repository.repositoryImplementation.PaymentPulsaRepositoryImpl;
import ali.ikbal.main.repository.repositoryImplementation.PaymentTokenRepositoryImpl;
import ali.ikbal.main.service.BalanceService;
import ali.ikbal.main.service.BankAccountService;
import ali.ikbal.main.service.PaymentPulsaService;
import ali.ikbal.main.service.PaymentTokenService;
import ali.ikbal.main.service.TransferService;
import ali.ikbal.main.service.serviceImplementation.BalanceServiceImpl;
import ali.ikbal.main.service.serviceImplementation.BankAccountServiceImpl;
import ali.ikbal.main.service.serviceImplementation.PaymentPulsaServiceImpl;
import ali.ikbal.main.service.serviceImplementation.PaymentTokenServiceImpl;
import ali.ikbal.main.service.serviceImplementation.TransferServiceImpl;
import ali.ikbal.main.utils.UtilInput;
import ali.ikbal.main.view.BankAccountView;

public class ServicBankAccountTest {

        public static void main(String[] args) {

                BankAccountRepositoryImpl bankAccountRepository = new BankAccountRepositoryImpl();

                PaymentPulsaRepositoryImpl paymentPulsa = new PaymentPulsaRepositoryImpl();
                PaymentTokenRepositoryImpl paymentToken = new PaymentTokenRepositoryImpl();

                // Initialize services with the repositories
                BalanceService balanceService = new BalanceServiceImpl(bankAccountRepository);
                BankAccountService bankAccountService = new BankAccountServiceImpl(bankAccountRepository);
                TransferService transferService = new TransferServiceImpl(bankAccountRepository);
                PaymentPulsaService paymentPulsaService = new PaymentPulsaServiceImpl(paymentPulsa);
                PaymentTokenService paymentTokenService = new PaymentTokenServiceImpl(paymentToken);

                // Initialize the view with the services and scanner
                Scanner scanner = new Scanner(System.in);
                BankAccountView bankAccountView = new BankAccountView(bankAccountService, balanceService, scanner,
                                transferService, paymentPulsaService, paymentTokenService);

                int attempts = 0;
                boolean isAuthenticated = false;
                while (attempts < 3 && !isAuthenticated) {
                        // Prompt user for PIN input
                        String pin = UtilInput.inputPin();

                        // Validate the entered PIN
                        if (balanceService.validatePin(pin)) { // Example account number
                                isAuthenticated = true;
                                // Show menu if the PIN is valid
                                bankAccountView.showMenu();
                        } else {
                                attempts++;
                                if (attempts < 3) {
                                        System.out.println("Invalid PIN. Please try again.");
                                }
                        }
                }

                if (!isAuthenticated) {
                        // Block the account after 3 failed attempts
                        System.out.println("Invalid PIN entered 3 times. Your account is blocked.");
                }
        }

}
