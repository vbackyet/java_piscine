package ex02;



public class User {
    private String Name;
    private Integer Balance;
    private Integer Identifier;

    // конструктор
    public User(String Name, Integer Balance)
    {
        setName(Name);
        this.Identifier = UserIdsGenerator.getInstance().generateId();
        setBalance(Balance);
    }

	public void setName(String name) {
		this.Name = name;
	}

    public void setBalance(Integer Balance) {
        if (Balance > 0)
		    this.Balance = Balance;
        else
            this.Balance = 0;

	}


    public Integer getIdentifier() {
		return Identifier;
	}

    public String getName() {
		return Name;
	}

    public Integer getBalance(){
		return Balance;
	}

	public String print_user() {
		return "User{" +
				"identifier=" + Identifier +
				", name='" + Name + '\'' +
				", balance=" + Balance +
				'}';
	}


    
}
