package ex03;

public class Program {

	public static void main(String[] args) {
		int max_usrs = 5;
		TransactionsLinkedList transactions = new TransactionsLinkedList();
		User sender = new User("Pupa", 123);
		User reciever = new User("Lupa", 0);

		for (int i = 0; i < max_usrs; i++) {
			Transaction tmp;
			if (i % 2 == 0) {
				tmp = new Transaction(sender, reciever, 123, Category.DEBIT);
			}	else {
				tmp = new Transaction(reciever, sender, 123, Category.DEBIT);
			}
			transactions.addTransaction(tmp);
		}
		
		Transaction[] t = transactions.toArray();
		for (int i = 0; i < transactions.getSizeOfList; i++)	{
			System.out.println(t[i].print_trans());
		}
		System.out.println("*******************");

		System.out.println(t[1].getIdentifier());
		
		transactions.removeTransaction(t[1].getIdentifier());

		Transaction[] t1 = transactions.toArray();
		
		for (int i = 0; i < transactions.getSizeOfList; i++)	{
			System.out.println(t1[i].print_trans());
		}

	}
}