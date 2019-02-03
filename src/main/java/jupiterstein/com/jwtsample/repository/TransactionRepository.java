package jupiterstein.com.jwtsample.repository;

import jupiterstein.com.jwtsample.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllByUserEmail(String userEmail);
}
