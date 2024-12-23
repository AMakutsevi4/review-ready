package ru.training.review.bankTransfer;

public class BankTransferService {

    private static double makeMoneyRub;

    public double transfer(String currency, double amount) {
        validate(currency, amount);
        return amount - calculateCommission(currency, amount);
    }

    private double calculateCommission(String currency, double amount) {
        if ("RUB".equalsIgnoreCase(currency) && amount > 1000) {
            makeMoneyRub += amount * 0.05;
            return amount * 0.05;
        } else if ("USD".equalsIgnoreCase(currency) && amount > 100) {
            makeMoneyRub += amount * 0.03 * 102.34; //конвертируем $ в рубли
            return amount * 0.03;
        }
        return 0;
    }

    private void validate(String currency, double amount) {
        if (!"RUB".equalsIgnoreCase(currency) && !"USD".equalsIgnoreCase(currency)) {
            throw new IllegalArgumentException("Доступные переводы RUB и USD: " + currency);
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }
    }

    public static void main(String[] args) {
        BankTransferService service = new BankTransferService();
        System.out.println(service.transfer("RUB", 1500));
        System.out.println(service.transfer("USD", 200));
        System.out.println("Прибыль банка в рублях составляет: " + makeMoneyRub);
    }
}