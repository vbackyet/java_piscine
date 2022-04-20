package ex03;
import java.util.UUID;
// Unlike users, a list of transactions requires a special implementation approach. 
// Since the number of transaction creation operations can be very large, we need a storage method to avoid a costly array size extension.

// In this task, we offer you to create TransactionsListinterface describing the following behavior:

//     Add a transaction
//     Remove a transaction by ID (in this case, UUID string identifier is used)
//     Transform into array (ex. Transaction[] toArray())

// A list of transactions shall be implemented as a linked list (LinkedList) in TransactionsLinkedList class. 
// Therefore, each transaction shall contain a field with a link to the next transaction object.
// If an attempt is made to remove a transaction with non-existent ID,
// TransactionNotFoundException runtime exception must be thrown.
// An example of use of such classes shall be contained in Program file (creation, initialization, printing object content on a console).

// Note:

//     We need to add transactions field of TransactionsList type to User class so that each user can store the list of their transactions.
//     A transaction must be added with a SINGLE operation (O(1))
//     LinkedList nested Java class has the same structure, a bidirectional linked list.



public class TransactionsLinkedList implements TransactionsList
{
    public TransNode head = new TransNode(null, null, null);
    public TransNode tail = new TransNode(null, null, null);
	public int getSizeOfList = 0;
    // 
	public TransactionsLinkedList() {
		head.setNext(tail);
		tail.setPrevious(head);
	}
    @Override
    public void addTransaction(Transaction new_transaction)
    {
		TransNode curr = new TransNode(head.getNext(), head, new_transaction);
		
		if (this.getSizeOfList == 0)
			tail.setPrevious(curr);
		else 
			head.getNext().setPrevious(curr);
		head.setNext(curr);
		getSizeOfList++;
    }
    @Override
    public void removeTransaction(UUID ID){
		TransNode curr = this.head.getNext();
		while(curr.getData() != null)	
		{
			Transaction curr_transaction = curr.getData();
			if (curr_transaction.getIdentifier() == ID)
			{
				
				TransNode prev = curr.getPrevious();
				TransNode next = curr.getNext();
				// System.out.println("\n\n\n" + prev.getData().print_trans() + "\n\n\n");
				// prev.setNext(curr.getNext());
				// System.out.println("\n\n\n" + curr.getNext().getData().print_trans() + "\n\n\n");
				prev.setNext(next);
				System.out.println("\n\n\n" + curr.getData().print_trans() + "\n\n\n");
				next.setPrevious(prev);
				curr.setData(null);
				curr.setNext(null);
				curr.setPrevious(null);
				// System.out.println("\n\n\n" + curr.getData().print_trans() + "\n\n\n");
				this.getSizeOfList--;
				return;
			}
			curr = curr.getNext();

		}
		throw new TransactionNotFoundException();
    }
    @Override
    public Transaction[] toArray()
    {
		Transaction[] myArray = new Transaction[getSizeOfList];
		TransNode begin = this.tail;
		// System.out.println(getSizeOfList);
		for (int i = 0; i < getSizeOfList; i++)
		{
			// System.out.println(i);
			begin = begin.getPrevious();
			// if (begin.getData() == null)
			// 	begin = begin.getPrevious();
			myArray[i] = begin.getData();
			// begin = begin.getPrevious();
		}
		return myArray;
    }
}
