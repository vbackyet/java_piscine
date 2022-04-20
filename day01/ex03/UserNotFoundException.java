package ex03;

public class UserNotFoundException extends RuntimeException{
    UserNotFoundException(int id)
    {
        System.out.println("User " + id + "not found:(");
    }
}
