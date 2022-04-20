package ex03;

//     Add a transaction
//     Remove a transaction by ID (in this case, UUID string identifier is used)
//     Transform into array (ex. Transaction[] toArray())
import java.util.UUID;


public interface TransactionsList {
    void addTransaction(Transaction new_transaction);
    void removeTransaction(UUID ID);
    Transaction[] toArray();  
}
