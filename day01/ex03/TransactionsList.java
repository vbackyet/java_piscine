package ex03;
import java.util.UUID;


public interface TransactionsList {
    void addTransaction(Transaction new_transaction);
    void removeTransaction(UUID ID);
    Transaction[] toArray();  
}
