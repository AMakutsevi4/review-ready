package ru.training.review.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.training.review.entity.BankTransfer;
import ru.training.review.repository.BankTransferRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BankTransferService {

    private final BankTransferRepository bankTransferRepository;

    public BankTransferService(BankTransferRepository bankTransferRepository) {
        this.bankTransferRepository = bankTransferRepository;
    }

    public List<BankTransfer> getAll() {
          return bankTransferRepository.findAll();
    }

    @Transactional
    public double transfer(String currency, double amount) {
        validate(currency, amount);
        double commission = calculateCommission(currency, amount);
        return amount - commission;
    }

    private double calculateCommission(String currency, double amount) {
        double commission = 0;
        if ("RUB".equalsIgnoreCase(currency) && amount > 1000) {
            commission = amount * 0.05;
        } else if ("USD".equalsIgnoreCase(currency) && amount > 100) {
            commission = amount * 0.03;
        }
        if (commission > 0) {
            double profitRub = "USD".equalsIgnoreCase(currency) ? commission * 102.34 : commission;
            bankTransferRepository.save(new BankTransfer(profitRub, LocalDateTime.now()));
        }
        return commission;
    }

    private void validate(String currency, double amount) {
        if (!"RUB".equalsIgnoreCase(currency) && !"USD".equalsIgnoreCase(currency)) {
            throw new IllegalArgumentException("Доступные переводы RUB и USD: " + currency);
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }
    }

}