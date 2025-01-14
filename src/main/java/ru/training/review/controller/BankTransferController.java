package ru.training.review.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.training.review.entity.BankTransfer;
import ru.training.review.service.BankTransferService;

import java.util.List;

@RestController
@RequestMapping("/api/transfer")
@RequiredArgsConstructor
public class BankTransferController {

    private final BankTransferService bankTransferService;


    @GetMapping
    public List<BankTransfer> getTransfers() {
        return bankTransferService.getAll();
    }

    @PostMapping
    public double transfer(@RequestParam String currency, @RequestParam double amount) {
        return bankTransferService.transfer(currency, amount);
    }
}