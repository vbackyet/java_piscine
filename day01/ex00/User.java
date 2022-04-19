package ex00;



public class User {
    private String Name;
    private Integer Balance;
    private Integer Identifier;

    // конструктор
    private User(String Name, Integer Balance, Integer Identifier)
    {
        setName(Name);
        setIdentifier(Identifier);
        setBalance(Balance);
    }

	public void setName(String name) {
		this.Name = name;
	}

    public void setIdentifier(Integer Identifier) {
		this.Identifier = Identifier;
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



    
}
