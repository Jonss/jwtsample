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

    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        String userEmail = getCurrentUser();
        return transactionRepository.findAllByUserEmail(userEmail);
    }

    private String getCurrentUser() {
        UserSpringSecurity user = (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }
}
