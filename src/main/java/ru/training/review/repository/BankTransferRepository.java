package ru.training.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import ru.training.review.entity.BankTransfer;

@Component
public interface BankTransferRepository extends JpaRepository<BankTransfer, Long> {
}
