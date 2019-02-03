package jupiterstein.com.jwtsample.service;

import jupiterstein.com.jwtsample.models.Transaction;
import jupiterstein.com.jwtsample.repository.TransactionRepository;
import jupiterstein.com.jwtsample.security.UserSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserService userService;

    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAllByUser(userService.getCurrentUser());
    }
}
