package ex03;


public class UserIdsGenerator {
	private static int id = 0;
    private static UserIdsGenerator instance;

	private UserIdsGenerator(){      
    }

	public static UserIdsGenerator getInstance(){ // #3
	if(instance == null){		//если объект еще не создан
		instance = new UserIdsGenerator();	//создать новый объект
	}
	return instance;		// вернуть ранее созданный объект
    }
	public Integer generateId() {
        id += 1;
        return id;
    }
}
   