package ali.ikbal.main.utils;

import java.util.Scanner;

public class UtilInput {

    public static Scanner scanner = new Scanner(System.in);

    public static int inputChoice() {
        return scanner.nextInt();
    }

    public static String input() {
        System.out.print("Masukan Account : ");
        return scanner.nextLine();
    }

    public static double inputDeposit() {
        System.out.print("Masukan Jumlah Deposit : ");
        return scanner.nextDouble();
    }

    public static double inputWithdraw() {
        System.out.print("Masukan Jumlah Withdraw : ");
        return scanner.nextDouble();
    }

    public static String inputPin() {
        System.out.print("Masukan Pin : ");
        return scanner.nextLine();
    }

    public static double inputAmount() {
        System.out.print("Masukan Jumlah Transfer : ");
        return scanner.nextDouble();
    }

    public static double inputPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan Jumlah Pembelian : ");
        return scanner.nextDouble();
    }

    public static String inputId() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan Nomor / ID Pel : ");
        return scanner.nextLine();
    }

}
