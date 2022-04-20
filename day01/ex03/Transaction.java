package ex03;


import java.util.UUID;
//mport java.util.Locale.Category;

// Transaction class describes a money transfer between two users. 
// Here, a unique identifier should also be defined. 
// Since the number of such transactions can be very large, let us define the identifier as an UUID string. 
// Thus, the following set of states (fields) is typical for Transaction class:

// It is necessary to check the initial user balance (it cannot be negative), 
// as well as the balance for the outgoing (negative amounts only) and incoming (positive amounts only) transactions (use of get/set methods).


public class Transaction {
	private UUID Identifier;
	private User Recipient;
	private User Sender;
	private Integer TransferAmount;
	private Category category;

	private enum Status {
		FAIL,
		SUCCESS
	}

	private Status status;
	public Category getCategory() {
		return category;
	}
	//конструктор 
	public Transaction(User sender, User recipient, Integer amount, Category type)
	{
		
	
		if (amount < 0 || sender.getBalance() < 0 || sender.getBalance() < amount)
		{
			
			setStatus(Status.FAIL);
			// System.exit(-1);
		}
		else
		{
			if (type == Category.CREDIT)
			{
				amount = -amount;
			}
			sender.setBalance(sender.getBalance() - amount);
			recipient.setBalance(recipient.getBalance() + amount);
			setStatus(Status.SUCCESS);
		}
		this.Recipient = recipient;
		this.Sender = sender;
		this.Identifier = UUID.randomUUID();
		this.TransferAmount = amount;
		this.category = type;
		
		// System.out.println("ushfvsidcvjdljfv");
		// System.exit(1);
	}
	// getters

	public UUID getIdentifier() {
		return Identifier;
	}

	public User getRecipient() {
		return Recipient;
	}
	public User getSender() {
		return Sender;
	}

	public Integer getAmount() {
		return TransferAmount;
	}

	public Status getStatus() {
		return status;
	}
	//setters
	public void setCategory(Category category) {
		this.category = category;
	}

	public void setRecipient(User recipient) {
		this.Recipient = recipient;
	}

	public void setIdentifier(UUID identifier) {
		this.Identifier = identifier;
	}

	public void setSender(User sender) {
		this.Sender = sender;
	}

	public void setAmount(Integer amount) {
		this.TransferAmount = amount;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public String print_trans() {
		return "Transaction{" +
				"identifier=" + Identifier +
				", recipient=" + Recipient +
				", sender=" + Sender +
				", amount=" + TransferAmount +
				", category=" + category +
				", status=" + status +
				'}';
	}


    
}
