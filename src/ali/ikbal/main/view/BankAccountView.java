package ali.ikbal.main.view;

import java.util.Scanner;

import ali.ikbal.main.entity.EntityPaymentPulsa;
import ali.ikbal.main.entity.EntityPaymentToken;
import ali.ikbal.main.service.BalanceService;
import ali.ikbal.main.service.BankAccountService;
import ali.ikbal.main.service.PaymentPulsaService;
import ali.ikbal.main.service.PaymentTokenService;
import ali.ikbal.main.service.TransferService;
import ali.ikbal.main.utils.UtilInput;

public class BankAccountView {

    private final BankAccountService bankAccountService;
    private final BalanceService balanceService;
    private final TransferService transferService;
    private final Scanner scanner;
    private final PaymentPulsaService paymentPulsa;
    private final PaymentTokenService paymentToken;

    public BankAccountView(BankAccountService bankAccountService, BalanceService balanceService, Scanner scanner,
            TransferService transferService, PaymentPulsaService paymentPulsa, PaymentTokenService paymentToken) {
        this.bankAccountService = bankAccountService;
        this.balanceService = balanceService;
        this.scanner = scanner;
        this.transferService = transferService;
        this.paymentPulsa = paymentPulsa;
        this.paymentToken = paymentToken;
    }

    public void showMenu() {

        while (true) {
            System.out.println("\nBank Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Check Balance");
            System.out.println("5. Other Payment");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = UtilInput.inputChoice();

            switch (choice) {
                case 1:
                    handleDeposit();
                    break;
                case 2:
                    handleWithdraw();
                    break;
                case 3:
                    handleTransfer();
                    break;
                case 4:
                    handleCheckBalance();
                    break;
                case 5:
                    handleOtherPayment();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    // System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleDeposit() {
        double amount = UtilInput.inputDeposit();
        System.out.println(amount);
        double newBalance = balanceService.deposit("123456", amount); // Example account number
        System.out.println("Deposit successful. New balance: " + newBalance);
    }

    private void handleWithdraw() {
        double amount = withdrawOptions();
        double balance = bankAccountService.showBankAccount("123456").getBalance().getAmount(); // Example account
        if (balance < amount) {
            System.out.println("Saldo Anda Tidak Cukup");
            showMenu();
        }
        // double amount = UtilInput.inputWithdraw();
        double newBalance = balanceService.withdraw("123456", amount); // Example account number
        System.out.println("Withdrawal successful." + amount + " New balance: " + newBalance);
    }

    private void handleTransfer() {
        System.out.println("TRANSFER");
        // Implement transfer logic here

        System.out.print("Enter the recipient account number: ");
        String toAccount = scanner.next();
        double amount = UtilInput.inputAmount();

        boolean success = transferService.transfer("123456", toAccount, amount); // Example account number
        if (success) {
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Transfer failed. Please check the account details or balance.");
        }
    }

    private void handleCheckBalance() {
        double balance = bankAccountService.showBankAccount("123456").getBalance().getAmount(); // Example account
                                                                                                // number
        System.out.println("Current balance: " + balance);
    }

    private void handleOtherPayment() {
        System.out.println("PAYMENT");
        System.out.println("1. Pulsa");
        System.out.println("2. Token Listrik");
        System.out.print("Select Payment :");
        int choice = UtilInput.inputChoice();
        switch (choice) {
            case 1:
                System.out.println("Payment Pulsa");
                String phoneNumber = UtilInput.inputId();
                double amount = UtilInput.inputPayment();
                paymentPulsa.buyPulsa(phoneNumber, amount);
                EntityPaymentPulsa entityPaymentPulsa = paymentPulsa.showAmountPhone(phoneNumber);
                if (entityPaymentPulsa != null) {
                    System.out.println(
                            "Payment successful." + amount + " New balance: " + entityPaymentPulsa.getAmountPhone());
                } else {
                    System.out.println("Transaksi Pembelian Pulsa Gagal");
                }
                break;
            case 2:
                System.out.println("Payment Token Listrik");
                String idToken = UtilInput.inputId();
                double buyToken = UtilInput.inputPayment();
                paymentToken.buyToken(idToken, buyToken);
                EntityPaymentToken entityPaymentToken = paymentToken.showAmountToken(idToken);
                if (entityPaymentToken != null) {
                    System.out.println(
                            "Payment Successful " + buyToken + " New Balance " + entityPaymentToken.getAmountToken());
                } else {
                    System.out.println("Maaf Transaksi Pembelian Token Gagal");
                }
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }

    private double withdrawOptions() {
        double[] options = { 50000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000 };

        System.out.println("\nWithdrawal Options:");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= options.length) {
            return options[choice - 1];
        } else {
            return -1; // Invalid choice
        }
    }

}
