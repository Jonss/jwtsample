package jupiterstein.com.jwtsample.service;

import jupiterstein.com.jwtsample.models.Transaction;
import jupiterstein.com.jwtsample.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction create(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll(HttpServletRequest request) {
        String userEmail = getUser(request);
        return transactionRepository.findAllByUserEmail(userEmail);
    }

    private String getUser(HttpServletRequest request) {
        return (String) request.getAttribute("user");
    }
}
